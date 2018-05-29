package com.pyramid.utils.file.properties;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import net.minidev.json.JSONObject;

//import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:25:36<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.file.properties<br>
 * @File: PropertiesUtil.java<br>
 * @Description: <br>
 */
public class PropertiesUtil {

	// logger
	private static Logger logger = Logger.getLogger(PropertiesUtil.class);

	//
	private static Properties props = null;
	private static File file = null;
	private static String path = null;
	private static String resource = "log4j.properties";
	private static InputStream in = null;
	private static PrintStream out = null;

	/**
	 * 加载指定的配置文件
	 * 
	 * @param properties
	 */
	public void getProperties(String... properties) {
		try {
			props = new Properties();
			for (String property : properties) {
				InputStream is = PropertiesUtil.class.getClassLoader()
						.getResourceAsStream(property);
				BufferedInputStream bis = (BufferedInputStream) is;
				props.load(bis);
			}
			logger.info(props.get("HELLO"));
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
			logger.info(key + value);
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
	public Map<String, String> readProperties() {
		Map<String, String> map = null;
		try {
			map = new ConcurrentHashMap<String, String>();
			in = new FileInputStream(new File(path));
			props.load(in);
			Enumeration<String> en = (Enumeration<String>) props
					.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String value = props.getProperty(key);
				map.put(key, value);
				// log the key and the value
				logger.info(key + "=" + value);
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
		return map;
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
			Set<Entry<String, Object>> entrySet = jsonObj.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				Object key = entry.getKey(), //
				value = entry.getValue(); //
				logger.info("key: " + key + ", value: " + value);
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

	/**
	 * Singleton
	 */
	public static PropertiesUtil propUtil;

	private PropertiesUtil() {
		props = new Properties();
		path = this.getClass().getClassLoader().getResource("").getPath();
		// in =
		// Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);//获取路径并转换成流
		path += resource;
		logger.info("path = " + path);
		// try {
		// in = new FileInputStream(new File(path + "/" + resource));
		// Logger.info((path);
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public static PropertiesUtil getInstance() {
		return propUtil == null ? new PropertiesUtil() : propUtil;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertiesUtil propUtil = PropertiesUtil.getInstance();

		// // 1.length
		// Logger.info(("length: " + propUtil.getProperitesLength());

		// // 2.write
		// JSONObject jsonObj = new JSONObject();
		// jsonObj.put("CPU", String.valueOf(Math.random()));
		// jsonObj.put("MEMORY", String.valueOf(Math.random()));
		// jsonObj.put("DISK", String.valueOf(Math.random()));
		// jsonObj.put("NETFLOW", String.valueOf(Math.random()));
		// propUtil.writeProperties(jsonObj);

		// 3.read
		propUtil.readProperties();

		// // 4.get
		// propUtil.getProperties();
	}
}
