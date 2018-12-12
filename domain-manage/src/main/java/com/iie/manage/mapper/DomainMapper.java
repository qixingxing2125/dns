package com.iie.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iie.common.mapper.SysMapper;
import com.iie.manage.pojo.Domain;

public interface DomainMapper extends SysMapper<Domain>{
	
	@Select("select * from alldomain where id=#{id}")
	Domain findDomainById(@Param("id")long id);

	int getRowCount(@Param("label")String label,@Param("name")String name,@Param("source")String source);

	List<Domain> findDomainByPage(@Param("start")int start,@Param("rows")Integer rows,@Param("label")String label,@Param("source")String source,@Param("name")String name);

	List<Domain> findByCondition(@Param("label")String label, @Param("source")String source, @Param("name")String name);
	
}
