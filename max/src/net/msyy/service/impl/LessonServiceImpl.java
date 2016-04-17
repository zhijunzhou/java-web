package net.msyy.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.msyy.dao.GradeCataDao;
import net.msyy.dao.LessonArrangementDao;
import net.msyy.dao.LessonCommentDao;
import net.msyy.dao.LessonDao;
import net.msyy.dao.LessonStatusDao;
import net.msyy.dao.LessonTypeDao;
import net.msyy.dao.StudentLessonDao;
import net.msyy.dao.SubjectDao;
import net.msyy.dao.TeacherDao;
import net.msyy.model.GradeCata;
import net.msyy.model.Lesson;
import net.msyy.model.LessonArrangement;
import net.msyy.model.LessonComment;
import net.msyy.model.LessonType;
import net.msyy.model.StudentLesson;
import net.msyy.model.Subject;
import net.msyy.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

	private LessonDao lessonDaoImpl;

	private LessonStatusDao lessonStatusDaoImpl;

	private LessonTypeDao lessonTypeDaoImpl;

	private LessonArrangementDao lessonArrangementDaoImpl;
	
	private LessonCommentDao lessonCommentDaoImpl;
	
	private StudentLessonDao studentLessonDaoImpl;

	private GradeCataDao gradeCataDaoImpl;

	private SubjectDao subjectDaoImpl;

	private TeacherDao teacherDaoImpl;

	@Resource
	public void setLessonDaoImpl(LessonDao lessonDaoImpl) {
		this.lessonDaoImpl = lessonDaoImpl;
	}

	@Resource
	public void setLessonCommentDaoImpl(LessonCommentDao lessonCommentDaoImpl) {
		this.lessonCommentDaoImpl = lessonCommentDaoImpl;
	}

	@Resource
	public void setStudentLessonDaoImpl(StudentLessonDao studentLessonDaoImpl) {
		this.studentLessonDaoImpl = studentLessonDaoImpl;
	}

	@Resource
	public void setLessonStatusDaoImpl(LessonStatusDao lessonStatusDaoImpl) {
		this.lessonStatusDaoImpl = lessonStatusDaoImpl;
	}

	@Resource
	public void setSubjectDaoImpl(SubjectDao subjectDaoImpl) {
		this.subjectDaoImpl = subjectDaoImpl;
	}

	@Resource
	public void setLessonTypeDaoImpl(LessonTypeDao lessonTypeDaoImpl) {
		this.lessonTypeDaoImpl = lessonTypeDaoImpl;
	}

	@Resource
	public void setLessonArrangementDaoImpl(
			LessonArrangementDao lessonArrangementDaoImpl) {
		this.lessonArrangementDaoImpl = lessonArrangementDaoImpl;
	}

	@Resource
	public void setGradeCataDaoImpl(GradeCataDao gradeCataDaoImpl) {
		this.gradeCataDaoImpl = gradeCataDaoImpl;
	}

	@Resource
	public void setTeacherDaoImpl(TeacherDao teacherDaoImpl) {
		this.teacherDaoImpl = teacherDaoImpl;
	}

	@Override
	public List queryLessonList() {
		// String hql = " select * " +
		// " from " +
		// " lesson as lsn," +
		// " lesson_arrangement as l_argmt," +
		// " lesson_status as l_sts, " +
		// " lesson_type as l_typ, " +
		// " grade_cata as gc, " +
		// " subject as sbj ";
		String hql = "from lesson_arrangement";
		return lessonDaoImpl.findAll(hql);
	}

	@Override
	public void saveLessonArrangement(LessonArrangement arrangement) {
		lessonArrangementDaoImpl.save(arrangement);
	}

	@Override
	public void saveLesson(Lesson lesson) {
		lessonDaoImpl.save(lesson);
	}

	@Override
	public void saveGradeCata(GradeCata gradeCata) {
		gradeCataDaoImpl.save(gradeCata);
	}

	@Override
	public void saveSubject(Subject subject) {
		subjectDaoImpl.save(subject);
	}

	@Override
	public List getLessonCountByTeacherAndLessonType(int teacher_id,
			int lesson_type_id) {
		String sql = "select time, COUNT(time),tea.teacher_id,lsn_type.name "
				+ "from lesson_arrangement as lsgt "
				+ "inner join teacher as tea on "
				+ "tea.teacher_id = lsgt.teacher_id "
				+ "inner join lesson_type as lsn_type on "
				+ "lsgt.lesson_type_id = lsn_type.lesson_type_id "
				+ " where tea.teacher_id = " + teacher_id;
		if (lesson_type_id > 0) {
			sql += " and lsn_type.lesson_type_id = " + lesson_type_id;
		}
		sql += " group by time, tea.teacher_id,lsn_type.name ";
		return lessonArrangementDaoImpl.findAllBySql(sql);
	}

	@Override
	public List queryLessonListByDate(String startdate, String enddate,
			Integer rank) {
		String topStr = "top 10";
		if (rank == 0) {
			topStr = "";
		}
		String sql = "select "
				+ topStr
				+ " * from ( "
				+ "select agt.lesson_arrangement_id,lsn.title,gc.grade_name,sbj.name as name0,lsn_type.name,agt.time,api.name as name1, "
				+ "agt.max_user,agt.price,agt.click_num,agt.enroll_num,lsn.imgUrl  "
				+ " from lesson_arrangement as agt "
				+ "inner join lesson as lsn on "
				+ "agt.lesson_id=lsn.lesson_id "
				+ "inner join teacher as tea on "
				+ "agt.teacher_id = tea.teacher_id "
				+ "inner join subject as sbj on "
				+ "lsn.subject_id = sbj.subject_id "
				+ "inner join lesson_type as lsn_type on "
				+ "lsn_type.lesson_type_id = agt.lesson_type_id "
				+ "inner join account_property_identity as api on "
				+ "tea.account_id = api.account_id "
				+ "inner join grade_cata as gc on "
				+ "lsn.grade_cata_id = gc.grade_cata_id " + " ) as temp ";
		if (startdate != null && !startdate.isEmpty()) {
			sql += " where temp.time between '" + startdate + "' " + " and '"
					+ enddate + "'";
		}
		if (rank != 0) {
			if (rank == 1) {
				sql += " order by temp.enroll_num desc";
			} else if (rank == 2) {
				sql += " order by temp.click_num desc";
			}
		}
		return lessonDaoImpl.findAllBySql(sql);
	}

	@Override
	public void saveLessonType(LessonType lessonType) {
		lessonTypeDaoImpl.save(lessonType);
	}

	@Override
	public LessonType getLessonTypeById(int lessonType_id) {
		return (LessonType) lessonTypeDaoImpl.findById(LessonType.class,
				lessonType_id);
	}

	@Override
	public LessonArrangement getLessonArrangementById(int lesson_arrangement_id) {
		return (LessonArrangement) lessonArrangementDaoImpl.findById(LessonArrangement.class, lesson_arrangement_id);
	}

	@Override
	public void updateLessonArrangement(LessonArrangement lessonArrangement) {
		lessonArrangementDaoImpl.update(lessonArrangement);
	}

	@Override
	public void saveLessonComment(LessonComment lessonComment) {
		lessonCommentDaoImpl.save(lessonComment);
	}

	@Override
	public List getLessonCommentsByLaId(int lesson_arrangement_id) {
		List list = lessonCommentDaoImpl.findAll(LessonComment.class, new String[]{"lessonArrangement.id"}, new Object[]{lesson_arrangement_id});
		return list;
	}

	@Override
	public void saveStudentLesson(StudentLesson studentLesson) {
		studentLessonDaoImpl.save(studentLesson);
	}

	@Override
	public List<StudentLesson> getStudentLessonBySidAid(int student_id,
			Integer lesson_arrangement_id) {
		if(lesson_arrangement_id == null) {
			return studentLessonDaoImpl.findAll(StudentLesson.class, new String[]{"student.id"},
					new Object[]{student_id});
		}
		return studentLessonDaoImpl.findAll(StudentLesson.class, new String[]{"student.id","lessonArrangement.id"},
				new Object[]{student_id,lesson_arrangement_id});
	}

	@Override
	public List getStudnetLessonByArragementId(Integer lesson_arrangement_id) {
		String sql = "select api.name,apc.email from student_lesson as s_l " +
				" inner join student as stu on " +
				" 	s_l.student_id = stu.student_id " +
				" inner join lesson_arrangement as la on " +
				"	s_l.lesson_arrangement_id = la.lesson_arrangement_id " +
				" inner join account_property_identity as api on " +
				"	stu.account_id = api.account_id " +
				" inner join account_property_contact as apc on " +
				"	stu.account_id = apc.account_id ";
		if(lesson_arrangement_id != null) {
			sql += " where la.lesson_arrangement_id = " + lesson_arrangement_id;
		}
		return studentLessonDaoImpl.findAllBySql(sql);
	}

	@Override
	public List queryLessonListByDate(String startdate, String enddate,
			Integer rank, Integer status) {
		String topStr = "top 10";
		if (rank == 0) {
			topStr = "";
		}
		String sql = "select "
				+ topStr
				+ " * from ( "
				+ "select agt.lesson_arrangement_id,lsn.title,gc.grade_name,sbj.name as name0,lsn_type.name,agt.time,api.name as name1, "
				+ "agt.max_user,agt.price,agt.click_num,agt.enroll_num,lsn.imgUrl,agt.lesson_status  "
				+ " from lesson_arrangement as agt "
				+ "inner join lesson as lsn on "
				+ "agt.lesson_id=lsn.lesson_id "
				+ "inner join teacher as tea on "
				+ "agt.teacher_id = tea.teacher_id "
				+ "inner join subject as sbj on "
				+ "lsn.subject_id = sbj.subject_id "
				+ "inner join lesson_type as lsn_type on "
				+ "lsn_type.lesson_type_id = agt.lesson_type_id "
				+ "inner join account_property_identity as api on "
				+ "tea.account_id = api.account_id "
				+ "inner join grade_cata as gc on "
				+ "lsn.grade_cata_id = gc.grade_cata_id " + " ) as temp where 1>0  ";
		if (startdate != null && !startdate.isEmpty()) {
			sql += " and temp.time between '" + startdate + "' " + " and '"
					+ enddate + "'";
		}
		if (status != null) {
			sql += " and temp.lesson_status = " + status;
		}
		if (rank != 0) {
			if (rank == 1) {
				sql += " order by temp.enroll_num desc";
			} else if (rank == 2) {
				sql += " order by temp.click_num desc";
			}
		}
		
		return lessonDaoImpl.findAllBySql(sql);
	}

}
