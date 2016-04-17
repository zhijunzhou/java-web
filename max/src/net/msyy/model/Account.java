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
 * 
 * 用户账户:account
 * 
 * @author Joe
 */
@Entity(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "account_id")
	private int id;

	@Column(name = "password")
	private String password;

	@Column(name = "reg_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reg_time;

	@JoinColumn(name = "role_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Role.class)
	private Role role;

	@JoinColumn(name = "role_group_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = RoleGroup.class)
	private RoleGroup role_group;

	@OneToMany(mappedBy = "account")
	private Set<PropertyIdentity> identities;

	@OneToMany(mappedBy = "account")
	private Set<PropertyContact> contacts;

	@OneToMany(mappedBy = "account")
	private Set<PropertyMisc> miscs;

	@OneToMany(mappedBy = "account")
	private Set<Operator> operators;

	@OneToMany(mappedBy = "account")
	private Set<Teacher> teachers;
	
	@OneToMany(mappedBy = "account")
	private Set<LessonComment> lessonComments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getReg_time() {
		return reg_time;
	}

	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleGroup getRole_group() {
		return role_group;
	}

	public void setRole_group(RoleGroup role_group) {
		this.role_group = role_group;
	}

	public Set<PropertyIdentity> getIdentities() {
		return identities;
	}

	public void setIdentities(Set<PropertyIdentity> identities) {
		this.identities = identities;
	}

	public Set<PropertyContact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<PropertyContact> contacts) {
		this.contacts = contacts;
	}

	public Set<PropertyMisc> getMiscs() {
		return miscs;
	}

	public void setMiscs(Set<PropertyMisc> miscs) {
		this.miscs = miscs;
	}

	public Set<Operator> getOperators() {
		return operators;
	}

	public void setOperators(Set<Operator> operators) {
		this.operators = operators;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public Set<LessonComment> getLessonComments() {
		return lessonComments;
	}

	public void setLessonComments(Set<LessonComment> lessonComments) {
		this.lessonComments = lessonComments;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

}
