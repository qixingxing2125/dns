package com.iie.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.manage.service.UserService;
import com.iie.manage.vo.JsonResult;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("loginUI")
	public String loginUI() {
		return "login";
	}
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username,String password) {
		userService.login(username,password);
		return new JsonResult("登录成功");
	}
}
