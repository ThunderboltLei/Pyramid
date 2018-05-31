package com.pyramid.web.controller.dashboard;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pyramid.service.login.LoginService;
import com.pyramid.web.controller.base.BaseController;

@Controller
@RequestMapping("dashboard")
public class DashboardController extends BaseController {

	private static final Logger LOG = Logger.getLogger(DashboardController.class);

	@Resource(name = "loginServiceImpl")
	private LoginService loginService;

	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toDashboard")
	public String toDashboard(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		LOG.info("----- toDashboard -----");
		return "/page/dashboard.jsp";
	}

}
