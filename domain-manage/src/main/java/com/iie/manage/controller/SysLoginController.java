package com.iie.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.common.vo.JsonResult;
import com.iie.manage.service.SysUserService;

@Controller
@RequestMapping("/")
public class SysLoginController {
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="doLogin",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doLogin(@RequestParam String username,@RequestParam String password) {
		sysUserService.login(username,password);
		return new JsonResult("Action OK");
	}
}
