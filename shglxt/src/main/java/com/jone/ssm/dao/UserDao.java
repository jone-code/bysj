package com.jone.ssm.dao;

import java.util.List;

import com.jone.ssm.pojo.User;

public interface UserDao {
	List<User> selectAll();
}
