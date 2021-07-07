package com.iie.manage.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.iie.common.vo.EasyUIResult;
import com.iie.common.vo.JsonResult;
import com.iie.common.vo.SysResult;
import com.iie.manage.pojo.SysDomain;
import com.iie.manage.service.SysDomainService;

@Controller
@RequestMapping("/domain")
public class SysDomainController {
	@Autowired
	private SysDomainService sysDomainService;

	@RequestMapping("/queryDomain")
	@ResponseBody
	public EasyUIResult findDomainByPage(String label,String source,String name,Integer page,Integer rows) {
		EasyUIResult result = sysDomainService.findDomainByParameter(label,source,name,page,rows);
		return result;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public SysResult deleteDomain(Long[] ids) {
		try {
			sysDomainService.deleteDomain(ids);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "域名删除失败");
	}

	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveDomain(SysDomain domain){
		try {
			sysDomainService.saveDomain(domain);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201,"域名新增失败");
	}

	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateDomain(SysDomain domain){
		try {
			sysDomainService.updateDomain(domain);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "域名修改失败");
	}

	@RequestMapping(value="/downloadCurrentData",method=RequestMethod.POST)
	@ResponseBody
	public String downloadCurrentData(String label,String source,String name,HttpServletResponse response) {
		sysDomainService.downloadCurrentData(label,source,name,response);
		return null;
	}

	@RequestMapping(value="/download",method=RequestMethod.GET)
	@ResponseBody
	public String downloadDomainById(@RequestParam("ids")Long[] ids,HttpServletResponse response) {
		sysDomainService.downloadDomainById(ids,response);
		return null;
	}

	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult uploadDomainFile(@RequestParam("uploadFile") MultipartFile uploadFile) {
		sysDomainService.uploadDomainFile(uploadFile);
		return new JsonResult("上传成功");
	}

	@RequestMapping(value="/saveFile",method=RequestMethod.POST)
	@ResponseBody
	public SysResult saveDomainFile(SysDomain domain) {
		try {
			sysDomainService.saveDomainFile(domain);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201,"域名新增失败");
	}
}
