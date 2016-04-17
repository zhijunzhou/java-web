package net.msyy.service;

import net.msyy.model.PropertyContact;

public interface PropertyContactService {

	public void save(PropertyContact propertyContact);
	
	public void update(PropertyContact propertyContact);
	
	public PropertyContact getPropertyContactById(int id);
	
	public PropertyContact getPropertyContactByAccountId(int id);
}
