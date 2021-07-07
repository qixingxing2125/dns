package com.iie.manage.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iie.common.pojo.Domain;
import com.iie.common.util.DomainFileUtils;
import com.iie.common.util.ExportExcelUtil;
import com.iie.common.vo.EasyUIResult;
import com.iie.manage.mapper.SysDomainMapper;
import com.iie.manage.mapper.SysLabelMapper;
import com.iie.manage.mapper.SysSourceMapper;
import com.iie.manage.mapper.SysTypeMapper;
import com.iie.manage.pojo.SysDomain;
import com.iie.manage.pojo.SysLabel;
import com.iie.manage.pojo.SysSource;
import com.iie.manage.pojo.SysType;
import com.iie.manage.service.SysDomainService;

@Service
public class SysDomainServiceImpl implements SysDomainService{
	
	@Autowired
	private SysDomainMapper sysDomainMapper;

	@Autowired
	private SysSourceMapper sysSourceMapper;

	@Autowired
	private SysLabelMapper sysLabelMapper;
	
	@Autowired
	private SysTypeMapper sysTypeMapper;

	@Override
	public EasyUIResult findDomainByParameter(String label, String source, String name, Integer page, Integer rows) {
		int labelId = 0;
		int sourceId = 0;
		if(label==null||label.equals("请选择")) {
			labelId = 0;
		}else {
			labelId = sysLabelMapper.findLabelId(label);
		}
		if (source == null||source.equals("请选择")) {
			sourceId = 0;
		}else {
			sourceId = sysSourceMapper.findSourceId(source);
		}
		int total = sysDomainMapper.getRowCount(labelId,sourceId,name);
		int start = (page - 1)*rows;
		List<SysDomain> domainList = sysDomainMapper.findDomainByPage(start,rows,labelId,sourceId,name);
		EasyUIResult result = new EasyUIResult(total,domainList);
		return result;
	}

	@Override
	public void deleteDomain(Long[] ids) {
		sysDomainMapper.deleteByIDS(ids);
	}

	@Override
	public void saveDomain(SysDomain domain) {
		sysDomainMapper.insertDomain(domain);
	}

	@Override
	public void updateDomain(SysDomain domain) {
		sysDomainMapper.updateByPrimaryKeySelective(domain);
	}
	
	@Override
	public void downloadCurrentData(String label, String source, String name, HttpServletResponse response) {
		Map<Integer, String> labelMap = new HashedMap<>();
		Map<Integer, String> sourceMap = new HashedMap<>();
		Map<Integer, String> typeMap = new HashedMap<>();
		String fileName = "域名信息表-" + label + "-" + source;
		int labelId = 0;
		int sourceId = 0;
		if(label==null||label.equals("请选择")) {
			labelId = 0;
		}else {
			labelId = sysLabelMapper.findLabelId(label);
		}
		if(source==null||source.equals("请选择")) {
			sourceId = 0;
		}else {
			sourceId = sysSourceMapper.findSourceId(source);
		}
		List<SysDomain> domainList = sysDomainMapper.findDoaminByCondition(labelId,sourceId,name);
		List<SysLabel> labelList = sysLabelMapper.findDomainLabel();
		for (SysLabel sysLabel : labelList) {
			labelMap.put(sysLabel.getId(), sysLabel.getName());
		}
		List<SysSource> sourceList = sysSourceMapper.findDomainSource();
		for (SysSource sysSource : sourceList) {
			sourceMap.put(sysSource.getId(), sysSource.getName());
		}
		List<SysType> typeList = sysTypeMapper.findDomainType();
		for (SysType sysType : typeList) {
			typeMap.put(sysType.getId(), sysType.getName());
		}
		List<Domain> domainL = new ArrayList<>();
		for (SysDomain sysDomain : domainList) {
			Domain domain = new Domain();
			domain.setId(sysDomain.getId());
			domain.setDomain(sysDomain.getDomain());
			domain.setSource(sourceMap.get(sysDomain.getSourceId()));
			domain.setLabel(labelMap.get(sysDomain.getLabelId()));
			domain.setType(typeMap.get(sysDomain.getTypeId()));
			domain.setLocation(sysDomain.getLocation());
			domain.setFoundtime(sysDomain.getFoundtime());
			domainL.add(domain);
		}
		String[] headers = {"序号","域名","数据来源","标签","类型","域名位置","时间"};
		ExportExcelUtil<Domain> ee = new ExportExcelUtil<Domain>();
		ee.exportExcel(headers,domainL,fileName,response);
	}

	@Override
	public void downloadDomainById(Long[] ids, HttpServletResponse response) {
		Map<Integer, String> labelMap = new HashedMap<>();
		Map<Integer, String> sourceMap = new HashedMap<>();
		Map<Integer, String> typeMap = new HashedMap<>();
		List<SysLabel> labelList = sysLabelMapper.findDomainLabel();
		for (SysLabel sysLabel : labelList) {
			labelMap.put(sysLabel.getId(), sysLabel.getName());
		}
		List<SysSource> sourceList = sysSourceMapper.findDomainSource();
		for (SysSource sysSource : sourceList) {
			sourceMap.put(sysSource.getId(), sysSource.getName());
		}
		List<SysType> typeList = sysTypeMapper.findDomainType();
		for (SysType sysType : typeList) {
			typeMap.put(sysType.getId(), sysType.getName());
		}
		String fileName = "域名信息表";
		List<Domain> domainList = new ArrayList<>();
		for (Long id : ids) {
			Domain domain = new Domain();
			SysDomain sysDomain = sysDomainMapper.findDomainById(id);
			domain.setId(sysDomain.getId());
			domain.setDomain(sysDomain.getDomain());
			domain.setSource(sourceMap.get(sysDomain.getSourceId()));
			domain.setLabel(labelMap.get(sysDomain.getLabelId()));
			domain.setType(typeMap.get(sysDomain.getTypeId()));
			domain.setLocation(sysDomain.getLocation());
			domain.setFoundtime(sysDomain.getFoundtime());
			domainList.add(domain);
		}
		String[] headers = {"序号","域名","数据来源","标签","类型","域名位置","时间"};
		ExportExcelUtil<Domain> ee = new ExportExcelUtil<Domain>();
		ee.exportExcel(headers,domainList,fileName,response);
	}

	@Override
	public void uploadDomainFile(MultipartFile multipartFile) {
		DomainFileUtils utils = new DomainFileUtils();
		String path = utils.findFilePath("file.properties");
		String fileName = multipartFile.getOriginalFilename();
		DomainFileUtils.fileName = fileName;
		try {
			multipartFile.transferTo(new File(path + "/" + fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveDomainFile(SysDomain domain) {
		String fileName = DomainFileUtils.fileName;
		DomainFileUtils utils = new DomainFileUtils();
		String path = utils.findFilePath("file.properties");
		List<String> domains = DomainFileUtils.getDomains(path + "/" + fileName);
		for (String domainStr : domains) {
			SysDomain sysDomain = new SysDomain();
			sysDomain.setDomain(domainStr);
			sysDomain.setSourceId(domain.getSourceId());
			sysDomain.setLabelId(domain.getLabelId());
			sysDomain.setTypeId(domain.getTypeId());
			sysDomain.setLocation(domain.getLocation());
			sysDomain.setFoundtime(domain.getFoundtime());
			sysDomainMapper.insert(sysDomain);
		}
	}
	
	
}
