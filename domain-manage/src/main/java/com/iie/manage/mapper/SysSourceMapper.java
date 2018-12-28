package com.iie.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iie.manage.pojo.SysSource;

public interface SysSourceMapper {

	List<SysSource> findDomainSource();

	String querySourceName(@Param("sourceId")Integer sourceId);

	int findSourceId(@Param("source")String source);

}
