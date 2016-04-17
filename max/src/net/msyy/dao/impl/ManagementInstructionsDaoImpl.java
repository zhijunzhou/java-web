package net.msyy.dao.impl;

import javax.annotation.Resource;

import net.msyy.dao.ManagementInstructionsDao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ManagementInstructionsDaoImpl extends BaseDaoImpl implements ManagementInstructionsDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
