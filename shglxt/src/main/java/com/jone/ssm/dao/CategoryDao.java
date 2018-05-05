package com.jone.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jone.ssm.pojo.Category;

public interface CategoryDao {
	List<Category> selectAll();
	void add(@Param("name")String name);
	void delete(@Param("id")int id);
	void update(@Param("id")int id, @Param("name")String name);
	Category selectById(@Param("id")int id);
	List<Category> selectByName(@Param("name")String name);
}
