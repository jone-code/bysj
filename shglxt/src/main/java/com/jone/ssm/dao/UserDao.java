package com.jone.ssm.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jone.ssm.pojo.User;


public interface UserDao {
	List<User> selectByUser(@Param("name")String name,@Param("password")String password);

	void updateUser(@Param("name")String name, @Param("password")String newOne);

	void insertUser(@Param("name")String name, @Param("password")String password, @Param("phone")String phone);

	List<User> selectByName(String name);
	
	List<User> selectAll();

	User selectUserById(@Param("id")int id);

	void deleteUserById(@Param("id")int id);

	void resetUserPassword(@Param("id")int id,@Param("password")String password);

	void updatePhone(@Param("id")int id,@Param("phone")String phone);
}
