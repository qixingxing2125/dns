package com.iie.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.manage.service.SourceDomainService;
import com.iie.manage.vo.CategoryResultVo;

@Controller
@RequestMapping("/source")
public class SourceDomainController {
	
	@Autowired
	private SourceDomainService sourceDomainService;
	
	@RequestMapping("/category")
	@ResponseBody
	public List<CategoryResultVo> sourceDomain(){
		List<CategoryResultVo> result = sourceDomainService.findDomainCategory();
		return result;
	}
}
