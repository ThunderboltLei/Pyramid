package com.pyramid.service.login;

import com.pyramid.service.base.BaseService;

/**
 * 
 * @param <T>
 * @param <T>
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:51:12<br>
 * @Project: Pyramid-Service<br>
 * @Package: com.pyramid.service.login<br>
 * @File: LoginService.java<br>
 * @Description: <br>
 */
public interface LoginService<TLoginUser> extends BaseService<TLoginUser> {

	// 是否注册过，true已经注册，false为未注册
	public boolean isRegisted(String email, String password);

	// 是否登录成功，true为成功，false为失败
	public boolean login(String email, String password);

	// 是否注册成功，true为成功，false为失败
	public boolean register();

}
