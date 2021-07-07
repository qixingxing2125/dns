package com.iie.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.common.vo.CategoryResultVo;
import com.iie.manage.mapper.SysLabelMapper;
import com.iie.manage.pojo.SysLabel;
import com.iie.manage.service.SysLabelService;

@Service
public class SysLabelServiceImpl implements SysLabelService{
	@Autowired
	private SysLabelMapper sysLabelMapper;
	
	@Override
	public List<CategoryResultVo> findDomainLabel() {
		List<CategoryResultVo> categoryList = new ArrayList<>();
		List<SysLabel> labelList = sysLabelMapper.findDomainLabel();
		CategoryResultVo resultVo = new CategoryResultVo();
		resultVo.setId(0);
		resultVo.setText("请选择");
		categoryList.add(resultVo);
		for (SysLabel sysLabel : labelList) {
			CategoryResultVo vo = new CategoryResultVo();
			vo.setId(sysLabel.getId());
			vo.setText(sysLabel.getName());
			categoryList.add(vo);
		}
		return categoryList;
	}

	@Override
	public String findNameById(Integer labelId) {
		String name = sysLabelMapper.queryLabelName(labelId);
		return name;
	}
}
