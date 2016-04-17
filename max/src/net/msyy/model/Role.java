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
 * @author Joe
 *	用户身份:role
 */
@Entity(name="role")
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="role_id")
	private int id;
	
	@Column(name="name" ,length=20)
	private String name; //教师 在校大学生 在校研究生
	
	@Column(name="description",length=200)//
	private String description;
	
	@OneToMany(mappedBy="role")
	private Set<Account> accouts;

	
	public Role() {
	}
	
	public Role(String name, String description) {
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

	public Set<Account> getAccouts() {
		return accouts;
	}

	public void setAccouts(Set<Account> accouts) {
		this.accouts = accouts;
	}
	
	
	
} 
 