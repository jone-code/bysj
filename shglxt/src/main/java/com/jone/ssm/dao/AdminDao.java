package com.jone.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jone.ssm.pojo.Admin;

public interface AdminDao {
	Admin selectOne(@Param("name")String name,@Param("password")String password);
	
	void insert(@Param("name")String name,@Param("password")String password);

	void update(@Param("name")String name,@Param("password")String password);
	
	List<Admin> selecAll();
	
	void deleteById(@Param("id")int id);

	List<Admin> selectByName(String name);
}
