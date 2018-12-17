package com.iie.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.common.vo.EasyUIResult;
import com.iie.manage.service.SysRoleService;

@Controller
@RequestMapping("/role")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("/queryRole")
	@ResponseBody
	public EasyUIResult findRoleByPage(Integer page,Integer rows,String name) {
		EasyUIResult result = sysRoleService.findRoleByParameter(page,rows,name);
		return result;
	}
	@RequestMapping(value="/queryRoleName",produces="text/html;charset=utf-8")
	@ResponseBody
	public String findRoleNameById(Integer roleId) {
		return sysRoleService.findNameById(roleId);
	}
}
