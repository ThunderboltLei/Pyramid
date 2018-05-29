package com.pyramid.web.controller.base;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月24日 下午4:33:53<br>
 * @Project: Pyramid-Web<br>
 * @Package: com.pyramid.web.web.controller.base<br>
 * @File: BaseController.java<br>
 * @Description: <br>
 */
public class BaseController {

	// 默认查询行数为10行
	protected static final int DEFAULT_PAGE_SIZE = 10;

	public String getPath(HttpServletRequest request) {
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath();
		return basePath;
	}

	public int getPageNum(int totCount, int pageSize) {
		if (totCount == 0) {
			return 0;
		} else if (totCount < pageSize) {
			return 1;
		} else {
			if (totCount % pageSize == 0) {
				return totCount / pageSize;
			} else {
				return totCount / pageSize + 1;
			}
		}
	}
}
