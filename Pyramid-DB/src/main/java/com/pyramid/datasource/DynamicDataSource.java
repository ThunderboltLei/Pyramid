package com.pyramid.datasource;

import java.sql.SQLException;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:22:30<br>
 * @Project: Pyramid-DB<br>
 * @Package: com.pyramid.datasource<br>
 * @File: DynamicDataSource.java<br>
 * @Description: <br>
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	public DynamicDataSource() {

	}

	@Override
	protected Object determineCurrentLookupKey() {
		// 在进行DAO操作前，通过上下文环境变量，获得数据源的类型
		return DataSourceContextHanlder.getDataSourceType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
