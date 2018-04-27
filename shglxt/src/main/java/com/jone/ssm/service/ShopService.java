package com.jone.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jone.ssm.dao.ShopDao;
import com.jone.ssm.pojo.Shop;

@Service
public class ShopService {

	@Autowired
	private ShopDao shopDao;
	
	public List<Shop> selectAll(){
		
		return shopDao.selectAll();
	}
}
