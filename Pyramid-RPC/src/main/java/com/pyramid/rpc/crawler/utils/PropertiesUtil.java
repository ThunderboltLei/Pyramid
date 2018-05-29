package com.pyramid.rpc.crawler.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

import net.sf.json.JSONObject;

public class PropertiesUtil {

	private static Properties props = null;
	private static File file = null;
	private static String path = null;
	private static String resource = "crawler.properties";
	private static InputStream in = null;
	private static PrintStream out = null;

	public PropertiesUtil() {
		props = new Properties();
		path = this.getClass().getClassLoader().getResource("").getPath();
		// in =
		// Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);//获取路径并转换成流
		path += resource;
		System.out.println("path = " + path);
		// try {
		// in = new FileInputStream(new File(path + "/" + resource));
		// System.out.println(path);
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	/**
	 * 加载指定的配置文件
	 * 
	 * @param properties
	 */
	public void getProperties(String... properties) {
		try {
			props = new Properties();
			for (String property : properties) {
				InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(property);
				BufferedInputStream bis = (BufferedInputStream) is;
				props.load(bis);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取配置文件中配置项个数
	 * 
	 * @return
	 */
	public int getProperitesLength() {
		try {
			in = new FileInputStream(new File(path));
			props.load(in);
			Enumeration en = props.propertyNames();
			return props.keySet().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public String Get(String key) {
		return props.getProperty(key);
	}

	/**
	 * 根据key读取value
	 * 
	 * @param key
	 * @return
	 */
	public String readValue(String key) {
		try {
			in = new FileInputStream(new File(path));
			props.load(in);
			String value = props.getProperty(key);
			// System.out.println(key + value);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取properties的全部信息
	 */
	public void readProperties() {
		try {
			in = new FileInputStream(new File(path));
			props.load(in);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String value = props.getProperty(key);
				System.out.println(key + "=" + value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 写入properties信息
	public void writeProperties(JSONObject jsonObj) {
		try {
			in = new FileInputStream(new File(path));
			props.load(in);
			/**
			 * 方法一
			 */
			out = new PrintStream(new File(path));
			Iterator it = jsonObj.keys();
			while (it.hasNext()) {
				Object key = it.next(), value = jsonObj.get(key);
				System.out.println("key: " + key + ", value: " + value);
				props.put(key, value);
			}
			props.list(out);
			/**
			 * 方法二
			 */
			// out.write(((key + 1) + "=fafafa\n").getBytes());
			// props.store(out, null);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				// out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PropertiesUtil propUtil = null;

	public static PropertiesUtil getInstance() {
		if (propUtil == null) {
			propUtil = new PropertiesUtil();
		}
		return propUtil;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertiesUtil propUtil = PropertiesUtil.getInstance();
		// // 1.length
		// System.out.println("length: " + propUtil.getProperitesLength());
		// // 2.write
		// JSONObject jsonObj = new JSONObject();
		// jsonObj.put("CPU", String.valueOf(Math.random()));
		// jsonObj.put("MEMORY", String.valueOf(Math.random()));
		// jsonObj.put("DISK", String.valueOf(Math.random()));
		// jsonObj.put("NETFLOW", String.valueOf(Math.random()));
		// propUtil.writeProperties(jsonObj);
		// // 3.read
		propUtil.readProperties();
	}
}
