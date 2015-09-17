package com.gz.university.crm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gz.university.crm.entity.SysUserGroup;




public interface ICommonDao<T> {
	public Serializable save(T o);

	public void delete(T o);

	public void update(T o);

	public void saveOrUpdate(T o);

	public T get(Class<T> c, Serializable id);
	public T get(String hql);

	public T get(String hql, Map<String, Object> params);
    
	public List<T> find(String hql);

	public List<T> find(String hql, Map<String, Object> params);

	public List<T> find(String hql, int page, int rows);

	public List<T> find(String hql, Map<String, Object> params, int page, int rows);
    /**
     * 根据语句查询记录的条数
     * @param hql
     * @return
     */
	public Long count(String hql);
    /**
     * 根据语句查询记录的条数,有参数
     * @param hql
     * @param params
     * @return
     */
	public Long count(String hql, Map<String, Object> params);

	public int executeHql(String hql);
	public int executeHqlByParams(String hql,Map<String, Object> params);

}
