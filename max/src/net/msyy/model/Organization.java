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
 *	组织单位:organization
 * @author Joe
 */
@Entity(name="organization")
public class Organization implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "organization_id")
	@GeneratedValue
	private int id;

	@Column(name = "name")
	private String name; // 湖北工业大学 新东方外语学校
	
	@JoinColumn(name="organization_type_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=OrganizationType.class)
	private OrganizationType org_type;
	
	@OneToMany(mappedBy="organization")
	private Set<Teacher> teachers;

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

	public OrganizationType getOrg_type() {
		return org_type;
	}

	public void setOrg_type(OrganizationType org_type) {
		this.org_type = org_type;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
