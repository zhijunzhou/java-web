package net.msyy.dao;

import java.util.List;

/**
 * 
 * @author Joe
 * @see BaseDaoImpl.class
 */
public interface BaseDao {
	
	public void save(Object obj);
	
	public void update(Object obj);
	
	public void delete(Object obj);
	
	@SuppressWarnings("rawtypes")
	public Object findById(Class clazz,int id);
	
	@SuppressWarnings("rawtypes")
	public List getList(Class clazz);
	
	public Object findOne(String hql);
	
	@SuppressWarnings("rawtypes")
	public Object findOne(Class clazz,String[] propertyname,Object[] params);
	
	@SuppressWarnings("rawtypes")
	public List findAll(String hql);
	
	@SuppressWarnings("rawtypes")
	public List findAll(String hql,Object[] params);
	
	@SuppressWarnings("rawtypes")
	public List findAll(Class claszz);
	
	@SuppressWarnings("rawtypes")
	public List findAll(Class claszz,int start,int pageSize);
	
	@SuppressWarnings("rawtypes")
	public List findAll(String hql, int pageNo, int pageSize); 
	
	@SuppressWarnings("rawtypes")
	public List findAll(Class clazz,String[] propertyname,Object[] params);

	public int getAllRowCount(String hql); 
	
	public List<?> findAllBySql(String sql);
}
