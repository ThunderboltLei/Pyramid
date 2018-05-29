package com.pyramid.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:51:05<br>
 * @Project: Pyramid-Service<br>
 * @Package: com.pyramid.service.base<br>
 * @File: BaseService.java<br>
 * @Description: <br>
 */
public interface BaseService<T> {

	public Serializable save(T object);

	public boolean update(T object);

	public boolean delete(T object);

	/**
	 * 直接拼sql语句容易暴漏住sql注入漏洞 建议使用setParameter来赋值 类似：<br/>
	 * {@link #createSQL(String sql, String key, String value)} <br/>
	 * {@link #createSQL(String, Map)} <br/>
	 * {@link #createSQL(String sql, String[] keys, String[] values)}
	 * 
	 * @param sql
	 * @return
	 */
	@Deprecated
	public List<T> createSQL(String sql);

	/**
	 * 直接拼sql语句容易暴漏住sql注入漏洞 建议使用setParameter来赋值 类似：<br/>
	 * {@link #createSQL(String sql, String key, String value)} <br/>
	 * {@link #createSQL(String, Map)} <br/>
	 * {@link #createSQL(String sql, String[] keys, String[] values)}
	 * 
	 * @param sql
	 * @return
	 */
	@Deprecated
	public int createSQLUpdate(String sql);

	/**
	 * 直接拼sql语句容易暴漏住sql注入漏洞 建议使用setParameter来赋值 类似：<br/>
	 * {@link #createSQL(String sql, String key, String value)} <br/>
	 * {@link #createSQL(String, Map)} <br/>
	 * {@link #createSQL(String sql, String[] keys, String[] values)}
	 * 
	 * @param sql
	 * @return
	 */
	@Deprecated
	public List<T> queryAll(String hql);

	/**
	 * 直接拼sql语句容易暴漏住sql注入漏洞 建议使用setParameter来赋值 类似：<br/>
	 * {@link #listAll(String sql, String key, String value, int currentPageNo, int pageSize)}
	 * <br/>
	 * {@link #listAll(String, Map, int , int )} <br/>
	 * {@link #listAll(String sql, String[] keys, String[] values, int currentPageNo, int pageSize)}
	 * 
	 * @param sql
	 * @return
	 */
	@Deprecated
	public List<T> listAll(String hsql, int currentPageNo, int pageSize);

	public T get(Class entityClass, Serializable id);

	public List<T> listAll(Class entityClass, int currentPageNo, int pageSize,
			String[] order);

	List<Map> createSQL(String sql, String key, String value);

	/**
	 * * ls_url="1" ls_url = "%2%" 示例(sql,new String[]{"lsurl","lsid"},new
	 * String[]{ls_url,ls_id})
	 * 
	 * @param sql
	 * @param keys
	 * @param values
	 * @return
	 */
	List<Map> createSQL(String sql, String[] keys, String[] values);

	List<Map> createSQL(String sql, Map<String, String> map);

	int createSQLUpdate(String sql, Map<String, String> map);

	int createSQLUpdate(String sql, String key, String value);

	/**
	 * * ls_url="1" ls_url = "%2%" 示例(sql,new String[]{"lsurl","lsid"},new
	 * String[]{ls_url,ls_id})
	 * 
	 * @param sql
	 * @param keys
	 * @param values
	 * @return
	 */
	int createSQLUpdate(String sql, String[] keys, String[] values);

	/**
	 * * ls_url="1" ls_url = "%2%" 示例(sql,new String[]{"lsurl","lsid"},new
	 * String[]{ls_url,ls_id})
	 * 
	 * @param sql
	 * @param keys
	 * @param values
	 * @return
	 */
	List<T> queryAll(String hql, String[] keys, String[] values);

	List<T> queryAll(String hql, String key, String value);

	List<T> queryAll(String hql, Map<String, String> map);

	List<T> listAll(String hsql, Map<String, String> map, int currentPageNo,
			int pageSize);

	List<T> listAll(String hsql, String key, String value, int currentPageNo,
			int pageSize);

	/**
	 * * ls_url="1" ls_url = "%2%" 示例(sql,new String[]{"lsurl","lsid"},new
	 * String[]{ls_url,ls_id})
	 * 
	 * @param sql
	 * @param keys
	 * @param values
	 * @return
	 */
	List<T> listAll(String hsql, String[] keys, String[] values,
			int currentPageNo, int pageSize);

}
