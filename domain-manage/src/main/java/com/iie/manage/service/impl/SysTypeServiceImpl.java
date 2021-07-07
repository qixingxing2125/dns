package com.iie.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.common.vo.CategoryResultVo;
import com.iie.manage.mapper.SysTypeMapper;
import com.iie.manage.pojo.SysType;
import com.iie.manage.service.SysTypeService;

@Service
public class SysTypeServiceImpl implements SysTypeService{
	@Autowired
	private SysTypeMapper sysTypeMapper;
	
	@Override
	public String findNameById(Integer typeId) {
		String typeName = sysTypeMapper.queryTypeName(typeId);
		return typeName;
	}

	@Override
	public List<CategoryResultVo> findDomainType() {
		List<CategoryResultVo> categoryList = new ArrayList<>();
		List<SysType> typeList = sysTypeMapper.findDomainType();
		CategoryResultVo resultVo = new CategoryResultVo();
		resultVo.setId(0);
		resultVo.setText("请选择");
		categoryList.add(resultVo);
		for (SysType sysType : typeList) {
			CategoryResultVo vo = new CategoryResultVo();
			vo.setId(sysType.getId());
			vo.setText(sysType.getName());
			categoryList.add(vo);
		}
		return categoryList;
	}

}
