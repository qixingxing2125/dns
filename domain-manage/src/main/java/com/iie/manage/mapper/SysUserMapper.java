package com.iie.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iie.common.mapper.SysMapper;
import com.iie.manage.pojo.SysUser;

public interface SysUserMapper extends SysMapper<SysUser>{

	int getRowCount(@Param("name")String name);

	List<SysUser> findUserByPage(@Param("start")int start,@Param("rows")Integer rows, @Param("name")String name);

	List<String> findUserPermissions(String username);

	SysUser findUserByUserName(@Param("username")String username);
	
}
