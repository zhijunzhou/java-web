package net.msyy.dao.impl;

import java.util.List;
import javax.annotation.Resource;

import net.msyy.dao.BaseDao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BaseDaoImpl implements BaseDao {

	//Logger log = Logger.getLogger(BaseDaoImpl.class);
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional("transactionManager")
	public void delete(Object obj) {
		this.sessionFactory.getCurrentSession().delete(obj);
	}
	
	@Transactional("transactionManager")
	public List findAll(Class clazz) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);		
		return criteria.list();
	}
	
	/**
	 */
	@Transactional("transactionManager")
	public List findAll(Class clazz, int startpage, int pageSize) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		int page = startpage * pageSize;
		criteria.setFirstResult(page);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}

	/**
	 * @param clazz
	 * @param propertyname
	 * @param params
	 * @return
	 */
	@Transactional("transactionManager")
	public Object findOne(Class clazz,String[] propertyname,Object[] params) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		for(int i = 0;i < params.length;i++) {
			criteria.add(Restrictions.eq(propertyname[i], params[i]));
		}
		return criteria.uniqueResult();
	}

	/**
	 */
	@Transactional("transactionManager")
	public List<?> findAll(String hql) {
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}


	/**
	 */
	@Transactional("transactionManager")
	public List findAll(String hql, int pageNo, int pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int page = (pageNo - 1) * pageSize;
		query.setFirstResult(page);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public List findAll(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 */
	@Transactional("transactionManager")
	public Object findById(Class clazz, int id) {
		return sessionFactory.getCurrentSession().createCriteria(clazz).add(Restrictions.eq("id", id)).uniqueResult();
	}


	@Transactional("transactionManager")
	public Integer findOne(String hql) {
		try{
			return (Integer) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		}catch(Exception e) {
			System.out.println("WARN:no unique result Exception;Expected one but more!");
			return 1;
		}
	}

	public Object findOne(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional("transactionManager")
	public int getAllRowCount(String hql) {
		return sessionFactory.getCurrentSession().createQuery(hql).list().size();
	}

	/**
	 */
	@Transactional("transactionManager")
	public List getList(Class clazz) {
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}

	/**
	 */
	@Transactional("transactionManager")
	public void save(Object obj) {
//		Session session =  sessionFactory.getCurrentSession();
//		session.save(session.merge(obj));
		sessionFactory.getCurrentSession().save(obj);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional("transactionManager")
	public void update(Object obj) {
		Session session =  sessionFactory.getCurrentSession();
		session.clear();
		session.saveOrUpdate(session.merge(obj));
	}
	
	@Transactional("transactionManager")
	public List findAll(Class clazz,String[] propertyname,Object[] params) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		for(int i = 0;i < params.length;i++) {
			criteria.add(Restrictions.eq(propertyname[i], params[i]));
		}
		return criteria.list();
	}

	@Transactional("transactionManager")
	public List findAllBySql(String sql) {
		return sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	}

}
