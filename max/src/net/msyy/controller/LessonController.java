package net.msyy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;

import net.msyy.common.CommonMessage;
import net.msyy.model.GradeCata;
import net.msyy.model.Lesson;
import net.msyy.model.LessonArrangement;
import net.msyy.model.LessonComment;
import net.msyy.model.LessonType;
import net.msyy.model.Student;
import net.msyy.model.StudentLesson;
import net.msyy.model.Subject;
import net.msyy.model.Teacher;
import net.msyy.service.LessonService;
import net.msyy.service.StudentService;
import net.msyy.service.TeacherService;
import net.msyy.util.DateUtil;
import net.msyy.util.FileUpload;
import net.msyy.util.MailSenderInfo;
import net.msyy.util.MassMail;
import net.msyy.util.MyAuthenticator;
import net.msyy.util.SimpleMailSender;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("lesson")
public class LessonController {

	private TeacherService teacherServiceImpl;

	private LessonService lessonServiceImpl;
	
	private StudentService studentServiceImpl;

	@Resource
	public void setTeacherServiceImpl(TeacherService teacherServiceImpl) {
		this.teacherServiceImpl = teacherServiceImpl;
	}
	
	@Resource
	public void setStudentServiceImpl(StudentService studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
	}

	@Resource
	public void setLessonServiceImpl(LessonService lessonServiceImpl) {
		this.lessonServiceImpl = lessonServiceImpl;
	}

	@RequestMapping(value = "/filterlist")
	public String filterlist(@RequestParam(required = false) String startdate,
			@RequestParam(required = false) String enddate,
			@RequestParam(required = false) Integer rank,
			@RequestParam(required = false) Integer key,
			@RequestParam(required = false) Integer status,
			HttpServletRequest request) {
		if (rank == null)
			rank = 0;
		List list = lessonServiceImpl.queryLessonListByDate(startdate, enddate,
				rank,status);
		List hotest = lessonServiceImpl.queryLessonListByDate(startdate, enddate,
				1);
		request.setAttribute("list", list);
		request.setAttribute("hotest", hotest);
		if(key == null) {
			return "/lesson/main.jsp";
		}
		return "/pro/filterLesson/filterLesson.jsp";
	}

	public String mappingWithGradeValue(int grade_value) {
		switch (grade_value) {
		case 1:
			return "小学";
		case 2:
			return "初中";
		case 3:
			return "高中";
		case 4:
			return "大专";
		case 5:
			return "大学";
		default:
		}
		return "其它";
	}

	public String uploadImage(HttpServletRequest request, MultipartFile imgAddr)
			throws Exception {
		String path = request.getSession().getServletContext()
				.getRealPath("upload/lesson/");
		String newName = DateUtil.flow()
				+ imgAddr.getOriginalFilename().substring(
						imgAddr.getOriginalFilename().lastIndexOf("."));
		FileUpload.upload(path, newName, imgAddr);
		return newName;
	}

	@RequestMapping(value = "/addLesson", method = RequestMethod.POST)
	public String addLesson(
			String lsn_name,
			String summary,
			String sbj_name,
			Integer grade_value,
			Integer lsn_type_name,
			Integer teacher_id,
			String argmt_time,
			Integer max_user,
			String addr,
			@RequestParam(value = "imgUrl", required = false) MultipartFile imgUrl,
			Integer price, HttpServletRequest request) throws ParseException {
		LessonArrangement arrangement = new LessonArrangement();
		Subject subject = new Subject();
		Lesson lesson = new Lesson();
		LessonType lessonType = lessonServiceImpl
				.getLessonTypeById(lsn_type_name);
		GradeCata gradeCata = new GradeCata();
		Teacher teacher;

		// gradecata
		gradeCata.setDescription("No Content");
		gradeCata.setGrade_value(grade_value);
		gradeCata.setGrade_name(mappingWithGradeValue(grade_value));

		// subject
		subject.setLessonType(lessonType);
		subject.setName(sbj_name);
		subject.setSummary("No Content");

		// lesson
		lesson.setTitle(lsn_name);
		lesson.setSummary(summary);

		String lessonImg_url = null;
		if (imgUrl != null && imgUrl.getSize() > 0) {
			try {
				lessonImg_url = uploadImage(request, imgUrl);
			} catch (Exception e) {
				System.out.println("File upload file!");
			}
			lesson.setImgUrl(lessonImg_url);
		}

		lesson.setSubject(subject);
		lesson.setGradeCata(gradeCata);

		// get Teacher
		teacher = teacherServiceImpl.getTeacherById(teacher_id);

		arrangement.setAddr(addr);
		arrangement.setPrice(price);
		arrangement.setLesson(lesson);
		arrangement.setLessonType(lessonType);
		arrangement.setMax_user(max_user);
		arrangement.setTeacher(teacher);
		arrangement.setLesson_status(CommonMessage.LESSON_STATUS_PRE);
		arrangement.setTime(new SimpleDateFormat("yyyy-MM-dd")
				.parse(argmt_time));
		try {
			lessonServiceImpl.saveGradeCata(gradeCata);

			lessonServiceImpl.saveSubject(subject);

			lessonServiceImpl.saveLessonArrangement(arrangement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/lesson/filterlist.do";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam Integer lesson_arrangement_id, HttpServletRequest request) {
		// search the lesson by id
		LessonArrangement lessonArrangement = lessonServiceImpl.getLessonArrangementById(lesson_arrangement_id);
		lessonArrangement.setClick_num(lessonArrangement.getClick_num() + 1);
		lessonServiceImpl.updateLessonArrangement(lessonArrangement);
		List comments = lessonServiceImpl.getLessonCommentsByLaId(lesson_arrangement_id);
		request.setAttribute("lessonArrangement", lessonArrangement);
		request.setAttribute("comments", comments);
		return "/lesson/detail.jsp";
	}
	
	@RequestMapping(value = "/lessonDetail", method = RequestMethod.GET)
	public String lessonDetail(@RequestParam Integer lesson_arrangement_id, HttpServletRequest request) {
		// search the lesson by id
		LessonArrangement lessonArrangement = lessonServiceImpl.getLessonArrangementById(lesson_arrangement_id);
		List comments = lessonServiceImpl.getLessonCommentsByLaId(lesson_arrangement_id);
		List students = lessonServiceImpl.getStudnetLessonByArragementId(lesson_arrangement_id);
		request.setAttribute("lessonArrangement", lessonArrangement);
		request.setAttribute("students", students);
		request.setAttribute("comments", comments);
		return "/lesson/lessonDetail.jsp";
	}
	
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComment(String content,Integer lesson_arrangement_id, HttpServletRequest request) {
		// search the lesson by id
		LessonArrangement lessonArrangement = lessonServiceImpl.getLessonArrangementById(lesson_arrangement_id);
		LessonComment lessonComment = new LessonComment();
		lessonComment.setContent(content);
		lessonComment.setLessonArrangement(lessonArrangement);
		lessonServiceImpl.saveLessonComment(lessonComment);
		return "redirect:/lesson/detail.do?lesson_arrangement_id=" + lesson_arrangement_id;
	}
	
	@ResponseBody
	@RequestMapping(value = "/join")
	public int join(@RequestParam Integer lesson_arrangement_id, HttpSession session) {
		Student student = (Student) session.getAttribute(CommonMessage.STUDENT_SESSION);
		if(student == null) {
			return CommonMessage.HTTP_NO_SESSION;
		}
		StudentLesson studentLesson = new StudentLesson();
		// TODO if the lesson has been joined, the data will not be saved.
		List list = lessonServiceImpl.getStudentLessonBySidAid(student.getId(), lesson_arrangement_id);
		if(list.size() <= 0) {
			LessonArrangement lessonArrangement = lessonServiceImpl.getLessonArrangementById(lesson_arrangement_id);
			try {
				studentLesson.setStudent(student);
				studentLesson.setLessonArrangement(lessonArrangement);
				lessonArrangement.setEnroll_num(lessonArrangement.getEnroll_num() + 1);
				lessonServiceImpl.saveStudentLesson(studentLesson);
			} catch (Exception e) {
				return CommonMessage.HTTP_ERROR;
			}
		} else {
			return CommonMessage.HTTP_R_EXIST;
		}
		
		return CommonMessage.HTTP_SUCCESS;
	}
	
	@RequestMapping(value = "/myStudyingLessons")
	public String myStudyingLessons(Integer lesson_arrangement_id,HttpSession session,HttpServletRequest request) {
		Student student = (Student) session.getAttribute(CommonMessage.STUDENT_SESSION);
		
		List list = lessonServiceImpl.getStudentLessonBySidAid(student.getId(), lesson_arrangement_id);
		request.setAttribute("studyList", list);
		return "/student/studying.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value = "/sendmail")
	public int sendmail(@RequestParam Integer lesson_arrangement_id,
			@RequestParam(required = false)  String[] maillist,HttpServletRequest request) {
		LessonArrangement la = lessonServiceImpl.getLessonArrangementById(lesson_arrangement_id);
		if(maillist == null || maillist.length <= 0) {
			return -1;
		}
		Arrays.toString(maillist);
		return MassMail.send(maillist, la) ? 0 : 1;
	}
	
	@ResponseBody
	@RequestMapping(value = "/startLesson")
	public int startLesson(@RequestParam Integer lesson_arrangement_id,HttpServletRequest request) {
		LessonArrangement la = lessonServiceImpl.getLessonArrangementById(lesson_arrangement_id);
		if(la.getLesson_status() == CommonMessage.LESSON_STATUS_PRE ) {
			la.setLesson_status(CommonMessage.LESSON_STATUS_START);
			lessonServiceImpl.updateLessonArrangement(la);
			return 1;
		} else if(la.getLesson_status() == CommonMessage.LESSON_STATUS_START) {
			return 2; // restart
		}
		return 3;
	}
	
	@ResponseBody
	@RequestMapping(value = "/stopLesson")
	public int stopLesson(@RequestParam Integer lesson_arrangement_id,HttpServletRequest request) {
		LessonArrangement la = lessonServiceImpl.getLessonArrangementById(lesson_arrangement_id);
		if(la.getLesson_status() == CommonMessage.LESSON_STATUS_START ) {
			la.setLesson_status(CommonMessage.LESSON_STATUS_END);
			lessonServiceImpl.updateLessonArrangement(la);
			return 1;
		} else if(la.getLesson_status() == CommonMessage.LESSON_STATUS_END) {
			return 2; // restart
		}
		return 3;
	}
	
	@RequestMapping(value = "/playVideo")
	public String playVideo(@RequestParam(required=true) String addr,HttpServletRequest request) {
		request.setAttribute("url", addr);
		return "/pro/video.jsp";
	}
	
	@RequestMapping(value = "/uploadVideo")
	public String uploadVideo(@RequestParam Integer lesson_arrangement_id,
			@RequestParam(value = "addr", required = false) MultipartFile addr,
			HttpServletRequest request) {
		String url = null;
		LessonArrangement la = lessonServiceImpl.getLessonArrangementById(lesson_arrangement_id);
		if (addr != null && addr.getSize() > 0) {
			try {
				url = uploadImage(request, addr);
			} catch (Exception e) {
				System.out.println("File upload file!");
			}
			la.setAddr(url);
			lessonServiceImpl.updateLessonArrangement(la);
		}
		return "redirect:/lesson/lessonDetail.do?lesson_arrangement_id=" + lesson_arrangement_id;
	}
}
