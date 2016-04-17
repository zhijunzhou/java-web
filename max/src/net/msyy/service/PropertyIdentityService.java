package net.msyy.service;

import net.msyy.model.PropertyIdentity;

public interface PropertyIdentityService {

	
	public void save(PropertyIdentity propertyIdentity);
	
	public void update(PropertyIdentity propertyIdentity);
	
	public PropertyIdentity getPropertyIdentityById(int id);
	
	public Object getPropertyIdentityByAccountId(int id);
}
