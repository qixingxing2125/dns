package com.iie.manage.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.iie.common.vo.EasyUIResult;
import com.iie.manage.pojo.SysDomain;

public interface SysDomainService {

	EasyUIResult findDomainByParameter(String label, String source, String name, Integer page, Integer rows);

	void deleteDomain(Long[] ids);

	void saveDomain(SysDomain domain);

	void updateDomain(SysDomain domain);

	void downloadCurrentData(String label, String source, String name, HttpServletResponse response);

	void downloadDomainById(Long[] ids, HttpServletResponse response);

	void uploadDomainFile(MultipartFile uploadFile);

	void saveDomainFile(SysDomain domain);
	
	
}
