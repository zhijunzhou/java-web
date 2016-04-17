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
 *	业务操作指令: management_instructions
 * @author Joe
 */
@Entity(name = "management_instructions")
public class ManagementInstructions implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "instructions_id")
	private int id;

	@Column(name = "name", unique = true)	
	private String name; // 操作名称 跟进 洽谈 签约

	@Column(name = "description")
	private String description;// 操作细节描述
	
	@OneToMany(mappedBy="managementInstructions")
	private Set<Operations> operations;

	

	public ManagementInstructions() {
	}

	public ManagementInstructions(String name, String description) {
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

	public Set<Operations> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operations> operations) {
		this.operations = operations;
	}
	
	

}
