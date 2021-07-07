package com.iie.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iie.common.mapper.SysMapper;
import com.iie.manage.pojo.SysDomain;

public interface SysDomainMapper extends SysMapper<SysDomain>{

	int getRowCount(@Param("labelId")int labelId, @Param("sourceId")int sourceId, @Param("name")String name);

	List<SysDomain> findDomainByPage(@Param("start")int start, @Param("rows")Integer rows, @Param("labelId")int labelId, @Param("sourceId")int sourceId, @Param("name")String name);

	void insertDomain(SysDomain domain);

	List<SysDomain> findDoaminByCondition(@Param("labelId")int labelId, @Param("sourceId")int sourceId, @Param("name")String name);

	SysDomain findDomainById(@Param("id")Long id);

}
