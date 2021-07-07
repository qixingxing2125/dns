package com.iie.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iie.manage.pojo.SysType;

public interface SysTypeMapper {

	String queryTypeName(@Param("typeId")Integer typeId);

	List<SysType> findDomainType();

}
