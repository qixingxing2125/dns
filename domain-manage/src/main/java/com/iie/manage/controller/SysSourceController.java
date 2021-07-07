package com.iie.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.common.vo.CategoryResultVo;
import com.iie.manage.service.SysSourceService;

@Controller
@RequestMapping("/source")
public class SysSourceController {
	@Autowired
	private SysSourceService sysSourceService;
	
	@RequestMapping("/category")
	@ResponseBody
	public List<CategoryResultVo> domainSource(){
		List<CategoryResultVo> result = sysSourceService.findDomainSouce();
		return result;
	}
	
	@RequestMapping(value="/querySourceName",produces="text/html;charset=utf-8")
	@ResponseBody
	public String findLabelName(Integer sourceId) {
		return sysSourceService.findNameById(sourceId);
	}
}
