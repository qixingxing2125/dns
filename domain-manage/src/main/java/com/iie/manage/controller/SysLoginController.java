package com.iie.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.common.vo.JsonResult;
import com.iie.manage.service.SysUserService;

@Controller
@RequestMapping("/")
public class SysLoginController {
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("logindo")
	@ResponseBody
	public JsonResult doLogin(String username,String password) {
		sysUserService.login(username,password);
		return new JsonResult("登录成功");
	}
}
