package com.pyramid.service.base.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pyramid.dao.base.BaseDAO;
import com.pyramid.service.base.BaseService;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:24:18<br>
 * @Project: Pyramid-Service<br>
 * @Package: com.pyramid.service.base.impl<br>
 * @File: BaseServiceImpl.java<br>
 * @Description: <br>
 */
@Service("BaseService")
@Transactional
public class BaseServiceImpl<Object> implements BaseService<Object> {

	private final static Logger logger = Logger
			.getLogger(BaseServiceImpl.class);

	@Resource(name = "BaseDao")
	private BaseDAO<Object> baseDao;

	/**
	 * @return the baseDao
	 */
	public BaseDAO<Object> getBaseDao() {
		return baseDao;
	}

	/**
	 * @param baseDao
	 *            the baseDao to set
	 */
	public void setBaseDao(BaseDAO<Object> baseDao) {
		this.baseDao = baseDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#save(java.lang.Object)
	 */
	public Serializable save(Object object) {
		// TODO Auto-generated method stub
		return baseDao.save(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#update(java.lang.Object)
	 */
	public boolean update(Object object) {
		// TODO Auto-generated method stub
		return baseDao.update(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#delete(java.lang.Object)
	 */
	public boolean delete(Object object) {
		// TODO Auto-generated method stub
		return baseDao.delete(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#createSQL(java.lang.String)
	 */
	public List<Object> createSQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pyramid.service.base.BaseService#createSQLUpdate(java.lang.String)
	 */
	public int createSQLUpdate(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#queryAll(java.lang.String)
	 */
	public List<Object> queryAll(String hql) {
		// TODO Auto-generated method stub
		return baseDao.queryAll(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#listAll(java.lang.String, int,
	 * int)
	 */
	public List<Object> listAll(String hsql, int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
		return baseDao.listAll(hsql, currentPageNo, pageSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#get(java.lang.Class,
	 * java.io.Serializable)
	 */
	public Object get(Class entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return (Object) baseDao.get(entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#listAll(java.lang.Class, int,
	 * int, java.lang.String[])
	 */
	public List<Object> listAll(Class entityClass, int currentPageNo,
			int pageSize, String[] order) {
		// TODO Auto-generated method stub
		return baseDao.listAll(entityClass, currentPageNo, pageSize, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#createSQL(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public List<Map> createSQL(String sql, String key, String value) {
		// TODO Auto-generated method stub
		return baseDao.createSQL(sql, key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#createSQL(java.lang.String,
	 * java.lang.String[], java.lang.String[])
	 */
	public List<Map> createSQL(String sql, String[] keys, String[] values) {
		// TODO Auto-generated method stub
		return baseDao.createSQL(sql, keys, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#createSQL(java.lang.String,
	 * java.util.Map)
	 */
	public List<Map> createSQL(String sql, Map<String, String> map) {
		// TODO Auto-generated method stub
		return baseDao.createSQL(sql, map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pyramid.service.base.BaseService#createSQLUpdate(java.lang.String,
	 * java.util.Map)
	 */
	public int createSQLUpdate(String sql, Map<String, String> map) {
		// TODO Auto-generated method stub
		return baseDao.createSQLUpdate(sql, map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pyramid.service.base.BaseService#createSQLUpdate(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public int createSQLUpdate(String sql, String key, String value) {
		// TODO Auto-generated method stub
		return baseDao.createSQLUpdate(sql, key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pyramid.service.base.BaseService#createSQLUpdate(java.lang.String,
	 * java.lang.String[], java.lang.String[])
	 */
	public int createSQLUpdate(String sql, String[] keys, String[] values) {
		// TODO Auto-generated method stub
		return baseDao.createSQLUpdate(sql, keys, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#queryAll(java.lang.String,
	 * java.lang.String[], java.lang.String[])
	 */
	public List<Object> queryAll(String hql, String[] keys, String[] values) {
		// TODO Auto-generated method stub
		return baseDao.queryAll(hql, keys, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#queryAll(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public List<Object> queryAll(String hql, String key, String value) {
		// TODO Auto-generated method stub
		return baseDao.queryAll(hql, key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#queryAll(java.lang.String,
	 * java.util.Map)
	 */
	public List<Object> queryAll(String hql, Map<String, String> map) {
		// TODO Auto-generated method stub
		return baseDao.queryAll(hql, map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#listAll(java.lang.String,
	 * java.util.Map, int, int)
	 */
	public List<Object> listAll(String hsql, Map<String, String> map,
			int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
		return baseDao.listAll(hsql, map, currentPageNo, pageSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#listAll(java.lang.String,
	 * java.lang.String, java.lang.String, int, int)
	 */
	public List<Object> listAll(String hsql, String key, String value,
			int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
		return baseDao.listAll(hsql, key, value, currentPageNo, pageSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.service.base.BaseService#listAll(java.lang.String,
	 * java.lang.String[], java.lang.String[], int, int)
	 */
	public List<Object> listAll(String hsql, String[] keys, String[] values,
			int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
		return baseDao.listAll(hsql, keys, values, currentPageNo, pageSize);
	}

}
