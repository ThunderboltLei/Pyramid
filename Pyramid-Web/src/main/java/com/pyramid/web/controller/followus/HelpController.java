package com.pyramid.web.controller.followus;

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
import com.pyramid.web.controller.dashboard.DashboardController;

@Controller
@RequestMapping("followus/help")
public class HelpController extends BaseController {

	private static final Logger LOG = Logger.getLogger(HelpController.class);

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
	@RequestMapping(value = "apis")
	public String showAPIs(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		LOG.info("----- showAPIs -----");
		return "/page/followus/apis.jsp";
	}

}
