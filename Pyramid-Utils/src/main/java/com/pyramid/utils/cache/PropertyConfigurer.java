package com.pyramid.utils.cache;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

	private static final Logger LOG = Logger.getLogger(PropertyConfigurer.class);

	private static ConcurrentHashMap<String, Object> ctxPropertiesMap;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		// spring载入配置文件(具体原理还在研究中)
		super.processProperties(beanFactoryToProcess, props);
		ctxPropertiesMap = new ConcurrentHashMap<String, Object>();
		// 便利加载的配置文件的键值，并根据键值获取到value值，然后一同保存进map对象
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	// 此方法根据map对象的键获取其value的值
	public static Object getContextProperty(String name) {
		return ctxPropertiesMap.get(name);
	}

	public static void print() {
		if (ctxPropertiesMap.isEmpty()) {
			LOG.info("--->>> PropertyConfigurer: load nothing from configuration files.");
		} else {
			ctxPropertiesMap.forEach((k, v) -> LOG.info("--->>> PropertyConfigurer: key = " + k + ", value = " + v));
		}
	}
}
