package com.pyramid.utils.file;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:26:51<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.file<br>
 * @File: PathUtil.java<br>
 * @Description: <br>
 */
public class PathUtil {

	/**
	 * class文件的根目录
	 */
	private StringBuilder root = new StringBuilder("/");

	/**
	 * 与根目录进行拼接，获得新的访问路径
	 * 
	 * @param anyWhere
	 * @return
	 */
	public String getPath(String anyWhere) {
		return anyWhere == null ? root.toString() : root.append(anyWhere)
				.toString();
	}

	/**
	 * Singleton
	 */
	private static PathUtil pathUtil;

	private PathUtil() {
	}

	public static PathUtil getInstance() {
		return pathUtil == null ? new PathUtil() : pathUtil;
	}

	public static void main(String[] args) {

		PathUtil pathUtil = PathUtil.getInstance();

		String anyWhere = PathUtil.class.getClass().getResource("/").getPath();
		System.out.println(pathUtil.getPath(anyWhere));

	}

}
