package com.iie.manage.service;

import javax.servlet.http.HttpServletResponse;

import com.iie.common.vo.EasyUIResult;
import com.iie.manage.pojo.Domain;

public interface DomainService {

	void downloadDomain(Long[] ids, HttpServletResponse response);

	void downloadAllDomain(String label, String source, String name, HttpServletResponse response);

	EasyUIResult findDomainByParameter(String label, String source, String name, Integer page, Integer rows);

	void deleteDomain(Long[] ids);
	
	void saveDomain(Domain domain);
	
	void updateDomain(Domain domain);
	
}
