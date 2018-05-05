package com.jone.ssm.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jone.ssm.consts.CodeConsts;
import com.jone.ssm.dao.UserDao;
import com.jone.ssm.pojo.User;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	public List<User> existUser(String name,String password){
		List<User> list = userDao.selectByUser(name, password);
		return list;
	}
	public boolean selectUser(String name, String old) {
		List<User> list = userDao.selectByUser(name, old);
		return CollectionUtils.isNotEmpty(list);
	}
	public void updateUser(String name, String newOne) {
		userDao.updateUser(name,newOne);
	}
	public void addUser(String name, String password, String phone) {
		userDao.insertUser(name, password, phone);
	}
	public boolean hasUser(String name) {
		List<User> users = userDao.selectByName(name);
		return CollectionUtils.isNotEmpty(users);
	}
	public List<User> selectAll(){
		return userDao.selectAll();
	}
	public User selectUserById(int id) {
		User u = userDao.selectUserById(id);
		return u;
	}
	
	public void  deleteUser(int id){
		userDao.deleteUserById(id);
	}
	public void resetUser(Integer id) {
		userDao.resetUserPassword(id,CodeConsts.password);
	}
	public void updatePhone(int id,String phone) {
		userDao.updatePhone(id,phone);
	}
}
