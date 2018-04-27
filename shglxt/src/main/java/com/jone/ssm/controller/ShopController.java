package com.jone.ssm.controller;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jone.ssm.pojo.Shop;
import com.jone.ssm.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;
	@RequestMapping("/shopList")
	public String getShopList(){

		List<Shop> list = shopService.selectAll();
		System.out.println(list.size());
		JSONArray str =JSONArray.fromObject(list);
		return str.toString();
	}
}
