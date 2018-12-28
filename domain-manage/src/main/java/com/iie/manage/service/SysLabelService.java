package com.iie.manage.service;

import java.util.List;

import com.iie.common.vo.CategoryResultVo;

public interface SysLabelService {

	List<CategoryResultVo> findDomainLabel();

	String findNameById(Integer labelId);

}
