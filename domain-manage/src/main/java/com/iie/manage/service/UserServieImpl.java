package com.iie.manage.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.manage.mapper.UserMapper;

@Service
public class UserServieImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void login(String username, String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		subject.login(token);
		Session session=SecurityUtils.getSubject().getSession();
		session.setAttribute("user", username);
	}

}
