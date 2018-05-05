package com.jone.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jone.ssm.pojo.Category;
import com.jone.ssm.pojo.Shop;
import com.jone.ssm.pojo.ShopDto;
import com.jone.ssm.service.CategoryService;
import com.jone.ssm.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;

	@RequestMapping("/index")
	public String getShopList(Model model, HttpServletRequest request) {

		List<Shop> list = shopService.selectAll();
		model.addAttribute("shopList", list);
		return "index/index";
	}

	@RequestMapping("/firstPage")
	public String firstPage(Model model) {
		List<Shop> list = shopService.selectAll();
		model.addAttribute("shopList", list);
		return "index/index";
	}

	@RequestMapping("/admin/shopList")
	public String shopList(Model model) {
		List<ShopDto> list = shopService.selectAllAndShopClass();
		model.addAttribute("shopList", list);
		return "admin/pages/shop-list";
	}

	@RequestMapping("/admin/deleteShop")
	public String deleteShop(HttpServletRequest request, Model model) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		shopService.deleteById(id);
		List<ShopDto> list = shopService.selectAllAndShopClass();
		model.addAttribute("shopList", list);
		return "admin/pages/shop-list";
	}

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/admin/toUpdateShop")
	public String toUpdateShop(HttpServletRequest request, Model model) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Shop shop = shopService.selectById(id);
		model.addAttribute("shop", shop);
		List<Category> list = categoryService.getAll();
		model.addAttribute("shopClassList", list);
		return "admin/pages/shop-update";
	}

	@RequestMapping(value = "/admin/shopUpdate", method = RequestMethod.POST)
	public String updateShop(HttpServletRequest request, Model model,
			@RequestParam("image") MultipartFile file)
			throws IllegalStateException, IOException {
		Shop shop = buildShop(request);
		String path = request.getServletContext().getRealPath("");
		if(!file.isEmpty()){
			String filename = file.getOriginalFilename();
			File newFile = new File(path + File.separator + "upload"
				+ File.separator + filename);
			file.transferTo(newFile);
			shop.setImage("upload" + File.separator + filename);
		}
		Shop ss= shopService.updateShop(shop);
		model.addAttribute("shop", ss);
		List<Category> list = categoryService.getAll();
		model.addAttribute("shopClassList", list);
		model.addAttribute("successMessage", "更新成功");
		return "admin/pages/shop-update";
	}

	private Shop buildShop(HttpServletRequest request) {
		
		String shopNumStr = request.getParameter("shopNum");
		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		double price = Double.parseDouble(priceStr);
		String countStr = request.getParameter("count");
		int count = Integer.parseInt(countStr);
		String classStr = request.getParameter("classid");
		int classid = Integer.parseInt(classStr);
		Shop shop = new Shop( shopNumStr, name, price, count, classid);
		String idStr = request.getParameter("id");
		if(StringUtils.isNotEmpty(idStr)){
			int id = Integer.parseInt(idStr);
			shop.setId(id);
		}
		return shop;
	}

	@RequestMapping("/admin/toShopAdd")
	public String toShopAdd(Model model) {
		List<Category> list = categoryService.getAll();
		model.addAttribute("shopClassList", list);
		return "admin/pages/shop-add";
	}

	@RequestMapping(value = "/admin/shopAdd", method = RequestMethod.POST)
	public String shopAdd(HttpServletRequest request, Model model,
			@RequestParam("image") MultipartFile file)
			throws IllegalStateException, IOException {
		if (!file.isEmpty()) {
			Shop shop = buildShop(request);
			String path = request.getServletContext().getRealPath("");
			String filename = file.getOriginalFilename();
			File newFile = new File(path + File.separator + "upload"
					+ File.separator + filename);
			file.transferTo(newFile);
			shop.setImage("upload" + File.separator + filename);
			shopService.insertShop(shop);
			model.addAttribute("successMessage", "添加成功");
		} else {
			model.addAttribute("message", "文件不能为空");
		}
		return "admin/pages/shop-add";
	}

}
