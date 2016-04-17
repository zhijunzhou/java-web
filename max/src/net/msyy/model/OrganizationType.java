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
 * 组织类型:organization_type
 * @author Joe
 */
@Entity(name = "organization_type")
public class OrganizationType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "organization_type_id")
	private int id;// 组织类型id

	@Column(name = "title")
	private String title; // 私立 公立 民企 培训机构

	@Column(name = "description")
	private String description;// 省五十强 市重点高中
	
	@OneToMany(mappedBy="org_type")
	private Set<Organization> organizations;

	public OrganizationType() {
	}
	
	public OrganizationType(String title, String description) {
		this.title = title;
		this.description = description;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(Set<Organization> organizations) {
		this.organizations = organizations;
	}
	
	
}
