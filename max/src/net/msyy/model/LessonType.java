package net.msyy.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 课程类型（公益课、线上公开课、一对一辅导……）:lesson_type
 * @author Joe
 *
 */
@Entity(name="lesson_type")
public class LessonType  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "lesson_type_id")
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy="lessonType")
	private Set<Subject> subjects;
	
	@OneToMany(mappedBy="lessonType")
	private Set<LessonArrangement> lessonArrangements;

	public LessonType() {
	}
	
	public LessonType(String name, String description) {
		this.name = name;
		this.description = description;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<LessonArrangement> getLessonArrangements() {
		return lessonArrangements;
	}

	public void setLessonArrangements(Set<LessonArrangement> lessonArrangements) {
		this.lessonArrangements = lessonArrangements;
	}
	
	
}
 