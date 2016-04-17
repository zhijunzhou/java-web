package net.msyy.service;

import net.msyy.model.PropertyMisc;

public interface PropertyMiscService {

	public void save(PropertyMisc propertyMisc);
	
	public void update(PropertyMisc propertyMisc);
	
	public PropertyMisc getPropertyMiscById(int id);
	
	public Object getPropertyMiscByAccountId(int id);
}
