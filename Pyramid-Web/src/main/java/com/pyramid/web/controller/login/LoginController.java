package com.pyramid.web.controller.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pyramid.datasource.DataSourceContextHanlder;
import com.pyramid.service.login.LoginService;
import com.pyramid.web.controller.base.BaseController;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月24日 下午4:35:12<br>
 * @Project: Pyramid-Web<br>
 * @Package: com.pyramid.web.controller.login<br>
 * @File: LoginController.java<br>
 * @Description: <br>
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {

	private Logger logger = Logger.getLogger(getClass());

	@Resource(name = "loginServiceImpl")
	private LoginService loginService;

	// /**
	// * @return the loginService
	// */
	// public LoginService getLoginService() {
	// return loginService;
	// }
	// /**
	// * @param loginService the loginService to set
	// */
	// public void setLoginService(LoginService loginService) {
	// this.loginService = loginService;
	// }

	/**
	 * 是否注册过，true已经注册，false为未注册
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "isRegisted")
	public Map<String, String> isRegisted(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String loginEMail = request.getParameter("loginEMail");
		String loginPassword = request.getParameter("loginPassword");

		Map<String, String> map = new HashMap<String, String>();
		try {
			DataSourceContextHanlder.setDataSourceType("dataSource1");
			boolean bool = loginService.isRegisted(loginEMail, loginPassword);
			DataSourceContextHanlder.clearDataSourceType();
			if (bool == true) {// 该邮箱已被占用
				map.put("ret", "1");
				map.put("cause", "帐号已注册!");
			} else {// 改邮箱可以注册
				map.put("ret", "0");
				map.put("cause", "帐号可用!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("ret", "2");
			map.put("cause", "网络出现问题!");
		}
		return map;
	}

	/**
	 * 是否登录成功，true为成功，false为失败
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toLogin")
	public String toLogin(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		String email = request.getParameter("loginEMail");
		String password = request.getParameter("loginPassword");
		logger.info("----- login -----\nemail: " + email + ", password: "
				+ password);

		// boolean bool = loginService.login(email, password);
		// return bool == true ? "/page/main.jsp" : "/page/error.jsp";
		return "/page/main.jsp";
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toRegister")
	public String toRegister(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		logger.info("----- toRegister -----");
		return "/page/panels.jsp";
	}
}
