package net.msyy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.msyy.dao.AcountDao;
import net.msyy.dao.LessonArrangementDao;
import net.msyy.dao.LessonCommentDao;
import net.msyy.dao.StudentLessonDao;
import net.msyy.model.Student;
import net.msyy.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private AcountDao acountDaoImpl;
	
	private StudentLessonDao studentLessonDaoImpl;
	
	private LessonArrangementDao lessonArrangementDaoImpl;
	
	private LessonCommentDao lessonCommentDaoImpl;

	@Resource
	public void setAcountDaoImpl(AcountDao acountDaoImpl) {
		this.acountDaoImpl = acountDaoImpl;
	}

	@Resource
	public void setStudentLessonDaoImpl(StudentLessonDao studentLessonDaoImpl) {
		this.studentLessonDaoImpl = studentLessonDaoImpl;
	}

	@Resource
	public void setLessonArrangementDaoImpl(
			LessonArrangementDao lessonArrangementDaoImpl) {
		this.lessonArrangementDaoImpl = lessonArrangementDaoImpl;
	}

	@Resource
	public void setLessonCommentDaoImpl(LessonCommentDao lessonCommentDaoImpl) {
		this.lessonCommentDaoImpl = lessonCommentDaoImpl;
	}

	@Override
	public void save(Student stu) {
		studentLessonDaoImpl.save(stu);
	}

	@Override
	public List students() {
		String sql = 
			"select " + 
				"stu.student_id,api.name, api.nick, apc.celphone,reg_time,email " + 
		    "from " + 
		       " account as act  " + 
		    "inner join " + 
		       " account_property_contact as apc  " + 
		         "   on apc.account_id = act.account_id  " + 
		    "inner join " + 
		      "  account_property_identity as api  " + 
		            "on api.account_id = act.account_id  " + 
		    "inner join  " + 
				"student as stu " + 
					"on stu.account_id = act.account_id";
		return studentLessonDaoImpl.findAllBySql(sql);
	}

	@Override
	public Student getStudentById(int student_id) {
		return (Student) studentLessonDaoImpl.findById(Student.class, student_id);
	}
	
	
}
