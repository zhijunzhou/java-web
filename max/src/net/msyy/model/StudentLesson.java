package net.msyy.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Joe
 *
 */
@Entity(name="student_lesson")
public class StudentLesson implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "student_Lesson_id")
	@GeneratedValue
	private int id;
	
	@JoinColumn(name="student_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Student.class)
	private Student student;
	
	@JoinColumn(name="lesson_arrangement_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=LessonArrangement.class)
	private LessonArrangement lessonArrangement;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public LessonArrangement getLessonArrangement() {
		return lessonArrangement;
	}

	public void setLessonArrangement(LessonArrangement lessonArrangement) {
		this.lessonArrangement = lessonArrangement;
	}
	
	
}
