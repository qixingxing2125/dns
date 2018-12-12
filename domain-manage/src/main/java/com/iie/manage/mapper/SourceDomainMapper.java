package com.iie.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.iie.common.mapper.SysMapper;
import com.iie.manage.pojo.Domain;

public interface SourceDomainMapper extends SysMapper<Domain>{
	
	@Select("SELECT DISTINCT source FROM alldomain")
	List<String> findDomainCate();
	
}
