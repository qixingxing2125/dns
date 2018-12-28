package com.iie.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.common.vo.EasyUIResult;
import com.iie.common.vo.SysResult;
import com.iie.manage.pojo.SysUser;
import com.iie.manage.service.SysUserService;

@Controller
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	private SysUserService sysUserServcie;
	
	@RequestMapping("queryUsers")
	@ResponseBody
	public EasyUIResult findUsersByPage(Integer page,Integer rows,String name) {
		EasyUIResult result = sysUserServcie.findUserByParameter(page,rows,name);
		return result;
	}
	
	@RequestMapping("saveUser")
	@ResponseBody
	public SysResult saveUser(SysUser enyity) {
		try {
			sysUserServcie.saveUser(enyity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "新增用户失败");
	}
}
