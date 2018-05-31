package com.pyramid.web.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pyramid.utils.cache.PropertyConfigurer;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月24日 下午4:33:53<br>
 * @Project: Pyramid-Web<br>
 * @Package: com.pyramid.web.web.controller.base<br>
 * @File: BaseController.java<br>
 * @Description: <br>
 */
public abstract class BaseController {

	private static final Logger LOG = Logger.getLogger(BaseController.class);

	public BaseController() {
		// LOG.info("access_domains: " +
		// PropertyConfigurer.getContextProperty("access_domains"));
	}

	// ----- page -----// 默认查询行数为10行
	protected static final int DEFAULT_PAGE_SIZE = 10;

	public String getPath(HttpServletRequest request) {
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
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
