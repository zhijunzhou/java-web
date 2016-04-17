package net.msyy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="lesson_comment")
public class LessonComment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "lesson_comment_id")
	@GeneratedValue
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date writeDate;
	
	private String content;
	
	@JoinColumn(name="lesson_arrangement_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=LessonArrangement.class)
	private LessonArrangement lessonArrangement;
	
	@JoinColumn(name="account_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Account.class)
	private Account account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LessonArrangement getLessonArrangement() {
		return lessonArrangement;
	}

	public void setLessonArrangement(LessonArrangement lessonArrangement) {
		this.lessonArrangement = lessonArrangement;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
