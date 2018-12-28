package com.iie.manage.service;

import java.util.List;

import com.iie.common.vo.CategoryResultVo;

public interface SysTypeService {

	String findNameById(Integer typeId);

	List<CategoryResultVo> findDomainType();

}
