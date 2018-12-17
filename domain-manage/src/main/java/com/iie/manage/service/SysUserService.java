package com.iie.manage.service;

import com.iie.common.vo.EasyUIResult;
import com.iie.manage.pojo.SysUser;

public interface SysUserService {

	EasyUIResult findUserByParameter(Integer page, Integer rows, String name);

	void saveUser(SysUser enyity);

	void login(String username, String password);

}
