package com.iie.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.common.util.ExportExcelUtil;
import com.iie.common.vo.EasyUIResult;
import com.iie.manage.mapper.DomainMapper;
import com.iie.manage.pojo.Domain;
import com.iie.manage.service.DomainService;

@Service
public class DomainServiceImpl implements DomainService{
	@Autowired
	private DomainMapper domainMapper;

	@Override
	public void downloadDomain(Long[] ids,HttpServletResponse response) {
		String fileName = "域名信息表";
		List<Domain> domainList = new ArrayList<>();
		for (Long id : ids) {
			Domain domain = domainMapper.findDomainById(id);
			domainList.add(domain);
		}
		String[] headers = {"序号","域名","数据来源","标签","类型","域名位置","时间"};
		ExportExcelUtil<Domain> ee = new ExportExcelUtil<Domain>();
		ee.exportExcel(headers,domainList,fileName,response);
	}

	@Override
	public void downloadAllDomain(String label, String source, String name, HttpServletResponse response) {
		if(label==null||label.equals("请选择")) {
			label = null;
		}
		if(source==null||source.equals("请选择")) {
			source = null;
		}
		String fileName = "域名信息表";
		List<Domain> domainList = domainMapper.findByCondition(label,source,name);
		String[] headers = {"序号","域名","数据来源","标签","类型","域名位置","时间"};
		ExportExcelUtil<Domain> ee = new ExportExcelUtil<Domain>();
		ee.exportExcel(headers,domainList,fileName,response);
	}

	@Override
	public EasyUIResult findDomainByParameter(String label, String source, String name, Integer page, Integer rows) {
		if(label==null||label.equals("请选择")) {
			label = null;
		}
		if(source==null||source.equals("请选择")) {
			source = null;
		}
		int total = domainMapper.getRowCount(label,name,source);
		int start = (page - 1) * rows;
		List<Domain> domainList = domainMapper.findDomainByPage(start,rows,label,source,name);
		EasyUIResult result = new EasyUIResult(total,domainList);
		return result;
	}

	@Override
	public void deleteDomain(Long[] ids) {
		domainMapper.deleteByIDS(ids);
	}

	@Override
	public void saveDomain(Domain domain) {
		domainMapper.insert(domain);
	}

	@Override
	public void updateDomain(Domain domain) {
		domainMapper.updateByPrimaryKeySelective(domain);
	}
}
