package net.msyy.dao.impl;

import javax.annotation.Resource;

import net.msyy.dao.OrganizationDao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationDaoImpl extends BaseDaoImpl implements OrganizationDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
