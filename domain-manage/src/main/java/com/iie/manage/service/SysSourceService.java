package com.iie.manage.service;

import java.util.List;

import com.iie.common.vo.CategoryResultVo;

public interface SysSourceService {

	List<CategoryResultVo> findDomainSouce();

	String findNameById(Integer sourceId);

}
