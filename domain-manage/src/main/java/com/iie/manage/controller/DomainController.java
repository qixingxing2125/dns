package com.iie.manage.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.common.vo.EasyUIResult;
import com.iie.manage.pojo.Domain;
import com.iie.manage.service.DomainService;
import com.iie.manage.vo.SysResult;

@Controller
@RequestMapping("/domain")
public class DomainController {
	@Autowired
	private DomainService domainService;

	@RequestMapping("/query")
	@ResponseBody
	public EasyUIResult findDomainByPage(String label,String source,String name,Integer page,Integer rows){
		EasyUIResult result = domainService.findDomainByParameter(label,source,name,page,rows);
		return result;
	}

	@RequestMapping(value="/download",method=RequestMethod.GET)
	@ResponseBody
	public String downloadDomain(@RequestParam("ids") Long[] ids,HttpServletResponse response) {
		domainService.downloadDomain(ids,response);
		return null;
	}
	@RequestMapping(value="/downloadall",method=RequestMethod.POST)
	@ResponseBody
	public String downloadAllDomain(String label,String source,String name,HttpServletResponse response) {
		domainService.downloadAllDomain(label,source,name,response);
		return null;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public SysResult deleteDomain(Long[] ids) {
		try {
			domainService.deleteDomain(ids);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "域名删除失败");
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveDomain(Domain domain){
		try {
			domainService.saveDomain(domain);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201,"域名新增失败");
	}
	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateDomain(Domain domain){
		try {
			domainService.updateDomain(domain);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "域名修改失败");
	}
}
