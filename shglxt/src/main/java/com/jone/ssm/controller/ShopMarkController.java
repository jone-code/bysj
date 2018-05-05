/*
 * @(#)ShopMarkController.java 2018年4月28日下午4:21:31 Test Copyright 2018 Thuisoft,
 * Inc. All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject
 * to license terms.
 */
package com.jone.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jone.ssm.dao.ShopMarketDao;
import com.jone.ssm.pojo.Shop;
import com.jone.ssm.pojo.ShopMarket;

/**
 * ShopMarkController
 * 
 * @author huayu
 * @version 1.0
 * 
 */
@Controller
public class ShopMarkController {

	@Autowired
	private ShopMarketDao shopMarketDao;

	@RequestMapping("/selectAllShopMarket")
	public String selectAllShopMarket(Model model) {
		List<ShopMarket> list = shopMarketDao.selectAll();
		model.addAttribute("shopMarkets", list);
		return "index/index";
	}
	
	
	
	@RequestMapping("/admin/shopMarketList")
	public String shopMarketList(Model model) {
		List<ShopMarket> list = shopMarketDao.selectAll();
		model.addAttribute("shopMarkets", list);
		return "admin/pages/shopMarket-list";
	}
	
	@RequestMapping("/admin/deleteShopMarket")
	public String deleteShopMarket(HttpServletRequest request,Model model){
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		shopMarketDao.delete(id);
		List<ShopMarket> list = shopMarketDao.selectAll();
		model.addAttribute("shopMarkets", list);
		return "admin/pages/shopMarket-list";
	}
	
	
	
	@RequestMapping(value="/shopMarketAdd",method = RequestMethod.POST)
	public String shopMarketAdd(HttpServletRequest request,Model model,@RequestParam("image") MultipartFile file) throws IllegalStateException, IOException{
		if (!file.isEmpty()) {
			String path = request.getServletContext().getRealPath("");
			String filename = file.getOriginalFilename();
			File newFile = new File(path + File.separator + "upload"
					+ File.separator + filename);
			file.transferTo(newFile);
			ShopMarket market= buildMarket(request);
			market.setImage("upload"+ File.separator + filename);
			shopMarketDao.add(market);
			model.addAttribute("successMessage", "添加成功");
		} else {
			model.addAttribute("message", "文件不能为空");
		}
		return "admin/pages/shopMarket-add";
	}



	private ShopMarket buildMarket(HttpServletRequest request) {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String info = request.getParameter("info");
		
		return new ShopMarket(name, address, info, "");
	}
	
}
