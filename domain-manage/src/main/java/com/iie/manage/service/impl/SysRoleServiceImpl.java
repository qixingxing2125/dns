package com.iie.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.common.vo.EasyUIResult;
import com.iie.manage.mapper.SysRoleMapper;
import com.iie.manage.pojo.SysRole;
import com.iie.manage.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService{
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Override
	public EasyUIResult findRoleByParameter(Integer page, Integer rows, String name) {
		int total = sysRoleMapper.getRowCount(name);
		int start = (page - 1)*rows;
		List<SysRole> roleList = sysRoleMapper.findRoleByPage(start,rows,name);
		EasyUIResult result = new EasyUIResult(total,roleList);
		return result;
	}
	@Override
	public String findNameById(Integer roleId) {
		String roleName = sysRoleMapper.queryRoleName(roleId);
		return roleName;
	}

}
