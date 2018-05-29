package com.pyramid.service.login.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pyramid.service.base.impl.BaseServiceImpl;
import com.pyramid.service.login.LoginService;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:41:29<br>
 * @Project: Pyramid-Service<br>
 * @Package: com.pyramid.service.login.impl<br>
 * @File: LoginServiceImpl.java<br>
 * @Description: <br>
 */
@Service("loginServiceImpl")
public class LoginServiceImpl<TLoginUser> extends BaseServiceImpl<TLoginUser>
		implements LoginService<TLoginUser> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pyramid.web.service.login.LoginService#isRegisted(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean isRegisted(String email, String password) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from TLoginUser where email='"
				+ email + "' and '" + password + "'");
		List<TLoginUser> list = super.queryAll(hql.toString());
		return (!list.isEmpty() || list.size() != 0) ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.web.service.login.LoginService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pyramid.web.service.login.LoginService#register()
	 */
	@Override
	public boolean register() {
		// TODO Auto-generated method stub
		return false;
	}

}
