package com.iie.manage.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.common.exception.ServiceException;
import com.iie.common.vo.EasyUIResult;
import com.iie.manage.mapper.SysUserMapper;
import com.iie.manage.pojo.SysUser;
import com.iie.manage.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService{
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public EasyUIResult findUserByParameter(Integer page, Integer rows, String name) {
		int total = sysUserMapper.getRowCount(name);
		int start = (page - 1)*rows;
		List<SysUser> userList = sysUserMapper.findUserByPage(start,rows,name);
		EasyUIResult result = new EasyUIResult(total,userList);
		return result;
	}

	@Override
	public void saveUser(SysUser enyity) {
		sysUserMapper.insert(enyity);
	}

	@Override
	public void login(String username, String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("用户名或者密码不正确");
		}
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("user", username);
	}

}
