package com.iie.manage.mapper;

import java.util.List;

import com.iie.manage.pojo.User;

public interface UserMapper {

	List<String> findUserPermissions(String username);

	User findUserByUserName(String username);
	
}
