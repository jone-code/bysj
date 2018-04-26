package com.jone.ssm.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jone.ssm.pojo.User;


public interface UserDao {
	List<User> selectByUser(@Param("name")String name,@Param("password")String password);
}
