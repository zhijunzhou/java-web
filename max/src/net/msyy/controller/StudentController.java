package net.msyy.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.msyy.service.LessonService;
import net.msyy.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("student")
public class StudentController {

	private StudentService studentServiceImpl;
	
	private LessonService lessonServiceImpl;
	
	@Resource
	public void setStudentServiceImpl(StudentService studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
	}
	
	@Resource
	public void setLessonServiceImpl(LessonService lessonServiceImpl) {
		this.lessonServiceImpl = lessonServiceImpl;
	}


	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		List list = studentServiceImpl.students();
		request.setAttribute("list", list);
		return "/student/main.jsp";
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		List hotest = lessonServiceImpl.queryLessonListByDate(null, null,
				1);
		request.setAttribute("hotest", hotest);
		return "/pro/pro.jsp";
	}
	
}
