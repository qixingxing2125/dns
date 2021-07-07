package com.iie.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iie.manage.pojo.SysLabel;

public interface SysLabelMapper {

	List<SysLabel> findDomainLabel();

	String queryLabelName(@Param("labelId")Integer labelId);

	int findLabelId(@Param("label")String label);

}
