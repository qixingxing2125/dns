package com.iie.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.common.vo.CategoryResultVo;
import com.iie.manage.service.SysTypeService;

@Controller
@RequestMapping("/type")
public class SysTypeController {
	@Autowired
	private SysTypeService sysTypeService;
	
	@RequestMapping(value="/queryTypeName",produces="text/html;charset=utf-8")
	@ResponseBody
	public String findTypeNameById(Integer typeId) {
		return sysTypeService.findNameById(typeId);
	}
	
	@RequestMapping("/category")
	@ResponseBody
	public List<CategoryResultVo> domainSource(){
		List<CategoryResultVo> result = sysTypeService.findDomainType();
		return result;
	}
}
