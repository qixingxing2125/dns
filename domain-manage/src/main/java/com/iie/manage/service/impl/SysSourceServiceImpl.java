package com.iie.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.common.vo.CategoryResultVo;
import com.iie.manage.mapper.SysSourceMapper;
import com.iie.manage.pojo.SysSource;
import com.iie.manage.service.SysSourceService;
@Service
public class SysSourceServiceImpl implements SysSourceService{
	
	@Autowired
	private SysSourceMapper sysSourceMapper;
	
	@Override
	public List<CategoryResultVo> findDomainSouce() {
		List<CategoryResultVo> categoryList = new ArrayList<>();
		List<SysSource> sourceList = sysSourceMapper.findDomainSource();
		CategoryResultVo resultVo = new CategoryResultVo();
		resultVo.setId(0);
		resultVo.setText("请选择");
		categoryList.add(resultVo);
		for (SysSource sysSource : sourceList) {
			CategoryResultVo vo = new CategoryResultVo();
			vo.setId(sysSource.getId());
			vo.setText(sysSource.getName());
			categoryList.add(vo);
		}
		return categoryList;
	}

	@Override
	public String findNameById(Integer sourceId) {
		String name = sysSourceMapper.querySourceName(sourceId);
		return name;
	}
	
}
