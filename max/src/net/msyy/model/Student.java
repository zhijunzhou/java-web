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
 * 
 * @author Joe
 *
 */
@Entity(name="student")
public class Student implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue
	private int id;

	@JoinColumn(name="account_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Account.class)
	private Account account;
	
	@OneToMany(mappedBy="student")
	private Set<StudentLesson> student_Lessons;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<StudentLesson> getStudent_Lessons() {
		return student_Lessons;
	}

	public void setStudent_Lessons(Set<StudentLesson> student_Lessons) {
		this.student_Lessons = student_Lessons;
	}
	
	
	
}
