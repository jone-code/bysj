package com.jone.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jone.ssm.pojo.Shop;
import com.jone.ssm.pojo.ShopDto;

public interface ShopDao {

	List<Shop> selectAll();

	List<ShopDto> selectAllAndShopClass();

	void deleteById(@Param("id")int id);

	Shop selectById(@Param("id")int id);

	void updateShop(@Param("shop")Shop shop);

	void insertShop(@Param("shop")Shop shop);
}
