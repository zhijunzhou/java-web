package net.msyy.dao.impl;

import javax.annotation.Resource;

import net.msyy.dao.ManagementStatusDao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ManagementStatusDaoImpl extends BaseDaoImpl implements ManagementStatusDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
