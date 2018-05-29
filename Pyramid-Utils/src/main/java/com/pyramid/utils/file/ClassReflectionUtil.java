package com.pyramid.utils.file;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:26:28<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.file<br>
 * @File: ClassReflectionUtil.java<br>
 * @Description: 使用类的映射机制，实现调用指定类中相关方法。<br>
 */
public class ClassReflectionUtil {

	private final static Logger logger = Logger
			.getLogger(ClassReflectionUtil.class);

	/**
	 * 得到一个类中的所有方法
	 * 
	 * @param clazz
	 *            指定的类
	 * @return
	 */
	public List<String> getAllMethods(Class clazz) {
		List<String> list = new ArrayList<String>();
		for (Method method : clazz.getMethods()) {
			list.add(method.getName());
		}
		return list;
		// return Arrays.asList(clazz.getMethods()).stream()
		// .map(method -> method.getName()).collect(Collectors.toList());
	}

	/**
	 * @param clazz
	 *            需要映射的类
	 * @param methodName
	 *            映射类中的方法
	 * @param parameters
	 *            映射类中方法的参数
	 */
	public void callMethod(Class clazz, String methodName, Object... parameters) {
		try {
			Method method = clazz.getMethod(methodName, Object[].class);
			method.setAccessible(true);
			/**
			 * invoke方法第二个参数必须是Object对象，如果传递的参数是个数据，需要强制转换
			 */
			method.invoke(clazz.newInstance(), (Object) parameters);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * 测试方法：要调用的自定义方法
	 * 
	 * @param parameters
	 *            参数数组
	 */
	public void testHello(Object... parameters) {
		StringBuilder sb = new StringBuilder("");
		if (parameters.length > 0) {
			for (Object parameter : parameters) {
				sb.append(parameter);
			}
		}
		logger.info("data: " + sb.toString());
	}

	/**
	 * Singleton
	 */
	private static ClassReflectionUtil classReflectionUtil;

	private ClassReflectionUtil() {

	}

	public static ClassReflectionUtil getInstance() {
		return classReflectionUtil == null ? new ClassReflectionUtil()
				: classReflectionUtil;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ClassReflectionUtil classReflectionUtil = ClassReflectionUtil
		// .getInstance();
		//
		// Arrays.asList(
		// classReflectionUtil.getAllMethods(ClassReflectionUtil.class))
		// .stream().forEach(System.out::println);
		//
		// /**
		// * Test: callMethod
		// */
		// classReflectionUtil.callMethod(ClassReflectionUtil.class,
		// "testHello",
		// new Object[] { "This", " is", " a", " class..." });

	}

}
