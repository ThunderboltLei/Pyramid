package com.pyramid.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:20:05<br>
 * @Project: Pyramid-DAO<br>
 * @Package: com.pyramid.dao.base<br>
 * @File: IBaseDao.java<br>
 * @Description: <br>
 */
public interface BaseDAO<T> {

	/**
	 * 保存ENTITY
	 * 
	 * @param object
	 */
	public Serializable save(T object);

	/**
	 * 删除ENTITY
	 * 
	 * @param object
	 */
	public boolean delete(T object);

	/**
	 * 更新ENTITY
	 * 
	 * @param object
	 */
	public boolean update(T object);

	/**
	 * 查询
	 * 
	 * @param hsql
	 *            => HQL / SQL
	 * @return List
	 */
	@Deprecated
	public List<T> queryAll(String hsql);

	/**
	 * HSQL查询指定页数的实体对象列表
	 * 
	 * @param entityClass
	 *            实体名.class
	 * @param currentPageNo
	 *            当前页号
	 * @param pageSize
	 *            显示条数
	 * @return List
	 */
	@Deprecated
	public List<T> listAll(String hsql, int currentPageNo, int pageSize);

	/**
	 * 查询单个实体
	 * 
	 * @param entityClass
	 *            实体名.class
	 * @param id
	 *            实体主键
	 * @return List
	 */
	public T get(Class<T> entityClass, Serializable id);

	/**
	 * QBC 分页
	 * 
	 * @param entityClass
	 * @param currentPageNo
	 * @param pageSize
	 * @param order
	 * @return
	 */
	public List<T> listAll(Class<T> entityClass, int currentPageNo,
			int pageSize, String[] order);

	/**
	 * @param hql
	 * @return
	 */
	@Deprecated
	public List<T> createSQL(String sql);

	/**
	 * @param sql
	 * @return
	 */
	@Deprecated
	public int createSQLUpdate(String sql);

	List<Map> createSQL(String sql, Map<String, String> map);

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

	int createSQLUpdate(String sql, Map<String, String> map);

	int createSQLUpdate(String sql, String key, String value);

	/**
	 * ls_url="1" ls_url = "%2%" 示例(sql,new String[]{"lsurl","lsid"},new
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

	List<T> listAll(String hql, Map<String, String> map, int currentPageNo,
			int pageSize);

	List<T> listAll(String hql, String key, String value, int currentPageNo,
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
	List<T> listAll(String hql, String[] keys, String[] values,
			int currentPageNo, int pageSize);

}
