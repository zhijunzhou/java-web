package net.msyy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.msyy.dao.PropertyIdentityDao;
import net.msyy.model.PropertyIdentity;
import net.msyy.service.PropertyIdentityService;

import org.springframework.stereotype.Service;

@Service
public class PropertyIdentityServiceImpl implements PropertyIdentityService {

	private PropertyIdentityDao propertyIdentityDaoImpl;

	@Resource
	public void setPropertyIdentityDaoImpl(
			PropertyIdentityDao propertyIdentityDaoImpl) {
		this.propertyIdentityDaoImpl = propertyIdentityDaoImpl;
	}

	@Override
	public void save(PropertyIdentity propertyIdentity) {
		propertyIdentityDaoImpl.save(propertyIdentity);
	}

	@Override
	public PropertyIdentity getPropertyIdentityById(int id) {
		return (PropertyIdentity) propertyIdentityDaoImpl.findById(PropertyIdentity.class, id);
	}

	@Override
	public void update(PropertyIdentity propertyIdentity) {
		propertyIdentityDaoImpl.update(propertyIdentity);
	}

	@Override
	public Object getPropertyIdentityByAccountId(int id) {
		String sql = "select identity_id from account_property_identity where account_id=" + id;
		List list = propertyIdentityDaoImpl.findAllBySql(sql);
		return list == null ? null : list.get(0);
	}
	
	
}
