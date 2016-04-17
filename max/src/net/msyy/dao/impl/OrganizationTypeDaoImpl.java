package net.msyy.dao.impl;

import javax.annotation.Resource;

import net.msyy.dao.OrganizationTypeDao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationTypeDaoImpl extends BaseDaoImpl implements OrganizationTypeDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
