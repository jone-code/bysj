package com.jone.ssm.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jone.ssm.dao.CategoryDao;
import com.jone.ssm.pojo.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> getAll(){
		return categoryDao.selectAll();
	}

	public void deleteById(int id) {
		 categoryDao.delete(id);
	}

	public Category selectById(int id) {
		return categoryDao.selectById(id);
	}

	public void updateCategory(int id, String name) {
		categoryDao.update(id,name);
	}

	public void addCategory(String name) {
		categoryDao.add(name);
	}
	
	public boolean hasName(String name){
		List<Category> lsit = categoryDao.selectByName(name);
		return CollectionUtils.isNotEmpty(lsit);
	}
}
