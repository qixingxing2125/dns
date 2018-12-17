package com.iie.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iie.common.mapper.SysMapper;
import com.iie.manage.pojo.SysRole;

public interface SysRoleMapper extends SysMapper<SysRole>{

	int getRowCount(@Param("name")String name);

	List<SysRole> findRoleByPage(@Param("start")int start, @Param("rows")Integer rows, @Param("name")String name);

	String queryRoleName(@Param("roleId")Integer roleId);
	
}
