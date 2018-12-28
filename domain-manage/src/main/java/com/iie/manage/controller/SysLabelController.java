package com.iie.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.common.vo.CategoryResultVo;
import com.iie.manage.service.SysLabelService;

@Controller
@RequestMapping("/label")
public class SysLabelController {
	@Autowired
	private SysLabelService sysLabelService;
	
	@RequestMapping("/category")
	@ResponseBody
	public List<CategoryResultVo> domainLabel(){
		List<CategoryResultVo> result = sysLabelService.findDomainLabel();
		return result;
	} 
	
	@RequestMapping(value="/queryLabelName",produces="text/html;charset=utf-8")
	@ResponseBody
	public String findLabelName(Integer labelId) {
		return sysLabelService.findNameById(labelId);
	}
}
