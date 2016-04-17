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
 *	组织类型:organization_type
 */
@Entity(name="role_group") // missing at the db.pdf
public class RoleGroup implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="role_group_id")
	private int role_group_id;

	@OneToMany(mappedBy="role_group")
	private Set<Account> accouts;

	public int getRole_group_id() {
		return role_group_id;
	}

	public void setRole_group_id(int role_group_id) {
		this.role_group_id = role_group_id;
	}

	public Set<Account> getAccouts() {
		return accouts;
	}

	public void setAccouts(Set<Account> accouts) {
		this.accouts = accouts;
	}
	
	
}
