package com.iie.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface LabelDomainMapper {
	@Select("SELECT DISTINCT label FROM alldomain")
	List<String> findDomainCate();
	
}
