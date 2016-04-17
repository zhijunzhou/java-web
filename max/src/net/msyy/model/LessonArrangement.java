package net.msyy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 课程安排:lesson_arrangement
 * @author Joe
 *
 */

@Entity(name="lesson_arrangement")
public class LessonArrangement  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "lesson_arrangement_id")
	@GeneratedValue
	private int id;
	
	@JoinColumn(name="lesson_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Lesson.class)
	private Lesson lesson;
	
	@JoinColumn(name="teacher_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Teacher.class)
	private Teacher teacher;
	
	@JoinColumn(name="lesson_type_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=LessonType.class)
	private LessonType lessonType;
	
	@OneToMany(mappedBy="lessonArrangement")
	private Set<LessonComment> lessonComments;
	
	@Temporal(TemporalType.DATE)
	private Date time;
	
	private int max_user;
	
	private int click_num;
	
	private int enroll_num;
	
	private String addr;
	
	private int price;
	
	private int lesson_status; // -1: not start, start: 0, end: 1

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLesson_status() {
		return lesson_status;
	}

	public void setLesson_status(int lesson_status) {
		this.lesson_status = lesson_status;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public int getClick_num() {
		return click_num;
	}

	public void setClick_num(int click_num) {
		this.click_num = click_num;
	}

	public int getEnroll_num() {
		return enroll_num;
	}

	public void setEnroll_num(int enroll_num) {
		this.enroll_num = enroll_num;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public LessonType getLessonType() {
		return lessonType;
	}

	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getMax_user() {
		return max_user;
	}

	public void setMax_user(int max_user) {
		this.max_user = max_user;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<LessonComment> getLessonComments() {
		return lessonComments;
	}

	public void setLessonComments(Set<LessonComment> lessonComments) {
		this.lessonComments = lessonComments;
	}
	
	
}
