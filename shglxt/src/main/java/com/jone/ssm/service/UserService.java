package com.jone.ssm.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jone.ssm.dao.UserDao;
import com.jone.ssm.pojo.User;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	public boolean existUser(String name,String password){
		List<User> list = userDao.selectByUser(name, password);
		return CollectionUtils.isNotEmpty(list);
	}
}
