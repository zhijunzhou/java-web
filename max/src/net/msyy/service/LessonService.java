package net.msyy.service;

import java.util.List;

import net.msyy.model.GradeCata;
import net.msyy.model.Lesson;
import net.msyy.model.LessonArrangement;
import net.msyy.model.LessonComment;
import net.msyy.model.LessonType;
import net.msyy.model.StudentLesson;
import net.msyy.model.Subject;

public interface LessonService {

	public List queryLessonList();
	
	public List queryLessonListByDate(String startdate, String enddate,Integer rank);
	
	public List queryLessonListByDate(String startdate, String enddate,Integer rank, Integer status);
	
	public void saveLessonArrangement(LessonArrangement arrangement);
	
	public void saveLessonType(LessonType lessonType);
	
	public void saveLesson(Lesson lesson);
	
	public void saveLessonComment(LessonComment lessonComment);
	
	public void saveGradeCata(GradeCata gradeCata);
	
	public void saveSubject(Subject subject);
	
	public void saveStudentLesson(StudentLesson studentLesson);
	
	public void updateLessonArrangement(LessonArrangement lessonArrangement);
	
	public List getLessonCountByTeacherAndLessonType(int teacher_id, int lesson_type_id);
	
	public LessonType getLessonTypeById(int lessonType_id);
	
	public LessonArrangement getLessonArrangementById(int lesson_arrangement_id);
	
	public List getLessonCommentsByLaId(int lesson_arrangement_id);
	
	public List getStudentLessonBySidAid(int student_id,Integer lesson_arrangement_id);
	
	public List getStudnetLessonByArragementId(Integer lesson_arrangement_id);
	
}
