package com.pyramid.dao.base.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pyramid.dao.base.BaseDAO;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:19:11<br>
 * @Project: Pyramid-DAO<br>
 * @Package: com.pyramid.dao.base.impl<br>
 * @File: BaseDao.java<br>
 * @Description: <br>
 */
@Repository("BaseDao")
@Transactional
public class BaseDAOImpl<T> implements BaseDAO<T> {

	private final static Logger logger = Logger.getLogger(BaseDAOImpl.class);

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * ENTITY
	 */
	@Override
	public Serializable save(T object) {
		Serializable s = null;
		try {
			s = sessionFactory.getCurrentSession().save(object);
		} catch (Exception e) {
			logger.error(e);
		}
		return s;
	}

	@Override
	public boolean delete(T object) {
		try {
			sessionFactory.getCurrentSession().delete(object);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	@Override
	public boolean update(T object) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(object);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	/**
	 * SQL
	 */
	@Override
	public List<T> createSQL(String sql) {
		List<T> list = null;
		try {
			list = sessionFactory.getCurrentSession().createSQLQuery(sql)
					.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	/**
	 * SQL,带简单参数
	 */
	@Override
	public List<Map> createSQL(String sql, Map<String, String> map) {
		List<Map> list = null;
		try {
			SQLQuery sq = sessionFactory.getCurrentSession()
					.createSQLQuery(sql);
			// sq.setProperties(map);
			for (Map.Entry<String, String> entry : map.entrySet()) {
				sq.setString(entry.getKey(), entry.getValue());
			}

			list = sq.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
					.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	/**
	 * SQL,带简单参数
	 */
	@Override
	public List<Map> createSQL(String sql, String key, String value) {
		List<Map> list = null;
		try {
			SQLQuery sq = sessionFactory.getCurrentSession()
					.createSQLQuery(sql);
			sq.setString(key, value);
			list = sq.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
					.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	/**
	 * SQL,带简单参数
	 */
	@Override
	public List<Map> createSQL(String sql, String[] keys, String[] values) {
		List<Map> list = null;
		try {
			SQLQuery sq = sessionFactory.getCurrentSession()
					.createSQLQuery(sql);
			int s = 0;
			for (String key : keys) {
				if (s < values.length) {
					String value = values[s] == null ? "" : values[s];
					sq.setString(key, value);
					s++;
				}
			}
			list = sq.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
					.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	@Override
	public int createSQLUpdate(String sql) {
		int num = 0;
		try {
			num = sessionFactory.getCurrentSession().createSQLQuery(sql)
					.executeUpdate();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return num;
	}

	/**
	 * SQL,带简单参数
	 */
	@Override
	public int createSQLUpdate(String sql, Map<String, String> map) {
		int num = 0;
		try {
			SQLQuery sq = sessionFactory.getCurrentSession()
					.createSQLQuery(sql);
			for (Map.Entry<String, String> entry : map.entrySet()) {
				sq.setString(entry.getKey(), entry.getValue());
			}

			num = sq.executeUpdate();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return num;

	}

	/**
	 * SQL,带简单参数
	 */
	@Override
	public int createSQLUpdate(String sql, String key, String value) {
		int num = 0;
		try {
			SQLQuery sq = sessionFactory.getCurrentSession()
					.createSQLQuery(sql);
			sq.setString(key, value);
			num = sq.executeUpdate();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return num;

	}

	/**
	 * SQL,带简单参数
	 */
	@Override
	public int createSQLUpdate(String sql, String[] keys, String[] values) {
		int num = 0;
		try {
			SQLQuery sq = sessionFactory.getCurrentSession()
					.createSQLQuery(sql);
			int s = 0;
			for (String key : keys) {
				if (s < values.length) {
					String value = values[s] == null ? "" : values[s];
					sq.setString(key, value);
					s++;
				}
			}
			num = sq.executeUpdate();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return num;
	}

	/**
	 * HSQL
	 */

	@Override
	public List<T> queryAll(String hql) {
		List<T> list = null;
		try {
			list = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	/**
	 * HQL,带简单参数
	 */
	@Override
	public List<T> queryAll(String hql, Map<String, String> map) {
		List<T> list = null;
		try {
			Query sq = sessionFactory.getCurrentSession().createQuery(hql);
			for (Map.Entry<String, String> entry : map.entrySet()) {
				sq.setString(entry.getKey(), entry.getValue());
			}
			list = sq.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	/**
	 * HQL,带简单参数
	 */
	@Override
	public List<T> queryAll(String hql, String key, String value) {
		List<T> list = null;
		try {
			Query sq = sessionFactory.getCurrentSession().createQuery(hql);
			sq.setString(key, value);
			list = sq.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	/**
	 * HQL,带简单参数
	 */
	@Override
	public List<T> queryAll(String hql, String[] keys, String[] values) {
		List<T> list = null;
		try {
			Query sq = sessionFactory.getCurrentSession().createQuery(hql);
			int s = 0;
			for (String key : keys) {
				if (s < values.length) {
					String value = values[s] == null ? "" : values[s];
					sq.setString(key, value);
					s++;
				}
			}
			list = sq.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	@Override
	public List<T> listAll(String hsql, int currentPageNo, int pageSize) {
		List<T> list = null;
		try {
			Query query = null;
			if (currentPageNo > 0 && pageSize > 0) {
				query = sessionFactory.getCurrentSession().createQuery(hsql)
						.setFirstResult((currentPageNo - 1) * pageSize)
						.setMaxResults(pageSize);
			}
			list = query.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	/**
	 * HQL,带简单参数
	 */
	@Override
	public List<T> listAll(String hql, Map<String, String> map,
			int currentPageNo, int pageSize) {
		List<T> list = null;
		try {
			Query query = null;
			if (currentPageNo > 0 && pageSize > 0) {
				query = sessionFactory.getCurrentSession().createQuery(hql);
				for (Map.Entry<String, String> entry : map.entrySet()) {
					query.setString(entry.getKey(), entry.getValue());
				}
				query.setFirstResult((currentPageNo - 1) * pageSize)
						.setMaxResults(pageSize);

			}
			list = query.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;

	}

	/**
	 * HQL,带简单参数
	 */
	@Override
	public List<T> listAll(String hql, String key, String value,
			int currentPageNo, int pageSize) {
		List<T> list = null;
		try {
			Query query = null;
			if (currentPageNo > 0 && pageSize > 0) {
				query = sessionFactory.getCurrentSession().createQuery(hql)
						.setString(key, value)
						.setFirstResult((currentPageNo - 1) * pageSize)
						.setMaxResults(pageSize);
			}
			list = query.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;

	}

	/**
	 * HQL,带简单参数
	 */
	@Override
	public List<T> listAll(String hql, String[] keys, String[] values,
			int currentPageNo, int pageSize) {
		List<T> list = null;
		try {
			Query query = null;
			if (currentPageNo > 0 && pageSize > 0) {
				query = sessionFactory.getCurrentSession().createQuery(hql);
				int s = 0;
				for (String key : keys) {
					if (s < values.length) {
						String value = values[s] == null ? "" : values[s];
						query.setString(key, value);
						s++;
					}
				}
				query.setFirstResult((currentPageNo - 1) * pageSize)
						.setMaxResults(pageSize);
			}
			list = query.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	/**
	 * Query By Criteria
	 */
	@Override
	public List<T> listAll(Class<T> entityClass, int currentPageNo,
			int pageSize, String[] order) {
		List<T> list = null;
		try {
			Criteria criteria = null;
			if (currentPageNo > 0 && pageSize > 0) {
				criteria = sessionFactory.getCurrentSession()
						.createCriteria(entityClass)
						.setFirstResult((currentPageNo - 1) * pageSize)
						.setMaxResults(pageSize);
			}
			// 判断是否有排序请求，如果有加入到排序方法中
			if (order != null) {
				for (int i = 0; i < order.length; i++) {
					criteria.addOrder(Order.desc(order[i]));
				}
			}
			list = criteria.list();
		} catch (HibernateException e) {
			logger.error(e);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entityClass, Serializable id) {
		T object = (T) sessionFactory.getCurrentSession().get(entityClass, id);
		return object;
	}

	/**
	 * OTHERS
	 */
	public void closeSession() {
		if (sessionFactory.getCurrentSession().isOpen()) {
			// System.out.println("connection is open ...");
			sessionFactory.getCurrentSession().close();
			logger.info("正在关闭session...");
		} else {
			// System.out.println("connection is closed ...");
			logger.info("session已经关闭...");
		}
	}

}
