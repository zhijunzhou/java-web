package net.msyy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.msyy.dao.PropertyContactDao;
import net.msyy.model.PropertyContact;
import net.msyy.service.PropertyContactService;

import org.springframework.stereotype.Service;

@Service
public class PropertyContactServiceImpl implements PropertyContactService {

	private PropertyContactDao propertyContactDaoImpl;
	
	
	@Resource
	public void setPropertyContactDaoImpl(PropertyContactDao propertyContactDaoImpl) {
		this.propertyContactDaoImpl = propertyContactDaoImpl;
	}

	@Override
	public void save(PropertyContact propertyContact) {
		propertyContactDaoImpl.save(propertyContact);
	}

	public PropertyContact getPropertyContactById(int id) {
		return (PropertyContact) propertyContactDaoImpl.findById(PropertyContact.class, id);
	}

	@Override
	public void update(PropertyContact propertyContact) {
		propertyContactDaoImpl.update(propertyContact);
	}

	@Override
	public PropertyContact getPropertyContactByAccountId(int id) {
		return (PropertyContact) propertyContactDaoImpl.findOne(PropertyContact.class, new String[]{"account.id"}, new Object[]{id});
	}

}
