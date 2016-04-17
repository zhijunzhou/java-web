package net.msyy.model;

import java.io.Serializable;
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

/**
 * 课程:lesson
 * @author Joe
 *
 */
@Entity(name="lesson")
public class Lesson  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "lesson_id")
	@GeneratedValue
	private int id;
	
	private String title;
	
	private String imgUrl;
	
	private String summary;
	
	@JoinColumn(name="subject_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Subject.class)
	private Subject subject;
	
	@JoinColumn(name="grade_cata_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=GradeCata.class)
	private GradeCata gradeCata;
	
	@OneToMany(mappedBy="lesson")
	private Set<LessonArrangement> lessonArrangements;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Subject getSubject() {
		return subject;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public GradeCata getGradeCata() {
		return gradeCata;
	}

	public void setGradeCata(GradeCata gradeCata) {
		this.gradeCata = gradeCata;
	}

	public Set<LessonArrangement> getLessonArrangements() {
		return lessonArrangements;
	}

	public void setLessonArrangements(Set<LessonArrangement> lessonArrangements) {
		this.lessonArrangements = lessonArrangements;
	}
	
	
}
