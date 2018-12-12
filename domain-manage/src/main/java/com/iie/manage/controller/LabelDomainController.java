package com.iie.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.manage.service.LabelDomainService;
import com.iie.manage.vo.CategoryResultVo;

@Controller
@RequestMapping("/label")
public class LabelDomainController {
	
	@Autowired
	private LabelDomainService labelDomainService;
	
	@RequestMapping("/category")
	@ResponseBody
	public List<CategoryResultVo> LabelDomain(){
		List<CategoryResultVo> result = labelDomainService.findDomainCategory();
		return result;
	}
}
