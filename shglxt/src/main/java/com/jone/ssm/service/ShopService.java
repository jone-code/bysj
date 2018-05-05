package com.jone.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jone.ssm.dao.ShopDao;
import com.jone.ssm.pojo.Shop;
import com.jone.ssm.pojo.ShopDto;

@Service
public class ShopService {

	@Autowired
	private ShopDao shopDao;
	
	public List<Shop> selectAll(){
		
		return shopDao.selectAll();
	}

	public List<ShopDto> selectAllAndShopClass() {
		return shopDao.selectAllAndShopClass();
	}

	public void deleteById(int id) {
		shopDao.deleteById(id);
	}

	public Shop selectById(int id) {
		return shopDao.selectById(id);
	}

	public Shop updateShop(Shop shop) {
		shopDao.updateShop(shop);
		return shopDao.selectById(shop.getId());
	}

	public void insertShop(Shop shop) {
		shopDao.insertShop(shop);
	}
}
