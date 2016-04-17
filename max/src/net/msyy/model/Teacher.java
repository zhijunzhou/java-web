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
 * 教师和机构（视为特殊用户）:teacher
 * sid字段参考“业务管理”
 * @author Joe
 */
@Entity(name="teacher")
public class Teacher implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "teacher_id")
	@GeneratedValue
	private int id;

	@JoinColumn(name="account_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Account.class)
	private Account account;// 1:n 老师账户下可有多个老师，当账户下老师个数大于1的时候视为机构

	@JoinColumn(name="management_status_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=ManagementStatus.class)
	private ManagementStatus managementStatus;// 但需求是一个老师只有一个组织关系的时候，1:1 ，老师可以有多个组织关系如老师是湖北工业大学，是**工程院研究院

	@JoinColumn(name="organization_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Organization.class)
	private Organization organization;
	
	@OneToMany(mappedBy="teacher")
	private Set<Operations> operations;
	
	@OneToMany(mappedBy="teacher")
	private Set<LessonArrangement> lessonArrangements;

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

	public Set<LessonArrangement> getLessonArrangements() {
		return lessonArrangements;
	}

	public void setLessonArrangements(Set<LessonArrangement> lessonArrangements) {
		this.lessonArrangements = lessonArrangements;
	}

	public ManagementStatus getManagementStatus() {
		return managementStatus;
	}

	public void setManagementStatus(ManagementStatus managementStatus) {
		this.managementStatus = managementStatus;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Set<Operations> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operations> operations) {
		this.operations = operations;
	}
	
	
}
