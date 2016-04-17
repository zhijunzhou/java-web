package net.msyy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 年级段:grade_cata
 * @author Joe
 *
 */
@Entity(name="grade_cata")
public class GradeCata  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "grade_cata_id")
	@GeneratedValue
	private int id;
	
	private int grade_value; //数字化年级名
	
	private String grade_name;
	
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade_value() {
		return grade_value;
	}

	public void setGrade_value(int grade_value) {
		this.grade_value = grade_value;
	}

	public String getGrade_name() {
		return grade_name;
	}

	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
