package com.iie.manage.service;

import com.iie.common.vo.EasyUIResult;

public interface SysRoleService {

	EasyUIResult findRoleByParameter(Integer page, Integer rows, String name);

	String findNameById(Integer roleId);
	
}
