package com.jone.ssm.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jone.ssm.dao.AdminDao;
import com.jone.ssm.pojo.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	public Admin selectAdmin(String name,String password){
		return adminDao.selectOne(name,password);
	}
	
	public List<Admin> selectAll(){
		return adminDao.selecAll();
	}
	
	public void insertAdmin(String name,String password){
		adminDao.insert(name, password);
	}
	
	public void updateAdmin(String name,String password){
		adminDao.update(name, password);
	}
	
	public void deleteById(int id){
		adminDao.deleteById(id);
	}

	public boolean hasAdmin(String name) {
		List<Admin> admins = adminDao.selectByName(name);
		return CollectionUtils.isNotEmpty(admins);
	}
}
