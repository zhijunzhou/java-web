package net.msyy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.msyy.dao.PropertyMiscDao;
import net.msyy.model.PropertyMisc;
import net.msyy.service.PropertyMiscService;

import org.springframework.stereotype.Service;

@Service
public class PropertyMiscServiceImpl implements PropertyMiscService {

	private PropertyMiscDao propertyMiscDaoImpl;

	@Resource
	public void setPropertyMiscDaoImpl(PropertyMiscDao propertyMiscDaoImpl) {
		this.propertyMiscDaoImpl = propertyMiscDaoImpl;
	}

	@Override
	public void save(PropertyMisc propertyMisc) {
		propertyMiscDaoImpl.save(propertyMisc);
	}

	@Override
	public PropertyMisc getPropertyMiscById(int id) {
		return (PropertyMisc) propertyMiscDaoImpl.findById(PropertyMisc.class, id);
	}

	@Override
	public void update(PropertyMisc propertyMisc) {
		propertyMiscDaoImpl.update(propertyMisc);
	}

	@Override
	public Object getPropertyMiscByAccountId(int id) {
		String sql = "select misc_id from account_property_misc where account_id=" + id;
		List list = propertyMiscDaoImpl.findAllBySql(sql);
		return list == null ? null : list.get(0);
	}
	
	
}
