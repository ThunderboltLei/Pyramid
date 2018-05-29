package com.pyramid.datasource;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:22:13<br>
 * @Project: Pyramid-DB<br>
 * @Package: com.pyramid.datasource<br>
 * @File: DataSourceContextHanlder.java<br>
 * @Description: <br>
 */
public class DataSourceContextHanlder {

	/**
	 * DataSourceContext, each thread has a datasource key
	 */
	public static final ThreadLocal contextHolder = new ThreadLocal();

	public static void setDataSourceType(String dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	public static String getDataSourceType() {
		return (String) contextHolder.get();
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}

}
