package net.msyy.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 *	管理状态（已聘、待聘、解聘、已签约……）: management_status
 * @author Joe
 *	
 */
@Entity(name = "management_status")
public class ManagementStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "management_status_id")
	private int id;

	@Column(name = "name", unique = true)
	private String name;// 管理状态 已聘 待聘 解聘 已签约

	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy="managementStatus")
	private Set<Teacher> teachers;

	public ManagementStatus() {
	}
	
	
	public ManagementStatus(String name, String description) {
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

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
