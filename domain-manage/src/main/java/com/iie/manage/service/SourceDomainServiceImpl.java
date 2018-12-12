package com.iie.manage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.manage.mapper.SourceDomainMapper;
import com.iie.manage.vo.CategoryResultVo;

@Service
public class SourceDomainServiceImpl implements SourceDomainService{
	
	@Autowired
	private SourceDomainMapper sourceDomainMapper;
	
	@Override
	public List<CategoryResultVo> findDomainCategory() {
		List<CategoryResultVo> list = new ArrayList<>();
		//获取类别
		List<String> categoryList = sourceDomainMapper.findDomainCate();
		int size = categoryList.size();
		CategoryResultVo resultV = new CategoryResultVo();
		resultV.setId(1);
		resultV.setText("请选择");
		list.add(resultV);
		for (int i = 2; i <= size + 1; i++) {
			CategoryResultVo resultVo = new CategoryResultVo();
			resultVo.setId(i);
			resultVo.setText(categoryList.get(i-2));
			list.add(resultVo);
		}
		return list;
	}
}
