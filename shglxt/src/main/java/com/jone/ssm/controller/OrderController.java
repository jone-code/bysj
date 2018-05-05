package com.jone.ssm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jone.ssm.dao.OrderDao;
import com.jone.ssm.dao.ShopDao;
import com.jone.ssm.dao.UserDao;
import com.jone.ssm.pojo.Order;
import com.jone.ssm.pojo.OrderDto;
import com.jone.ssm.pojo.Shop;
import com.jone.ssm.pojo.User;

@Controller
public class OrderController {

	@Autowired
	private OrderDao orderDao;

	@RequestMapping("/admin/getAll")
	public String getAll(Model model){
		List<OrderDto> list = orderDao.selectAll();
		model.addAttribute("orderList", list);
		return "admin/pages/order-list";
	}
	
	@RequestMapping("/admin/toUpdateOrder")
	public String toUpdateOrder(HttpServletRequest request,Model model){
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		Order order = orderDao.selectById(id);
		model.addAttribute("order", order);
		return "admin/pages/order-update";
	}
	
	@RequestMapping(value = "/admin/updateOrder",method=RequestMethod.POST)
	public String updateOrder(HttpServletRequest request,Model model){
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Order o = new Order();
		String shopCount = request.getParameter("shopCount");
		int count = Integer.parseInt(shopCount);
		o.setShopCount(count);
		String price = request.getParameter("price");
		double p = Double.parseDouble(price);
		o.setPrice(p);
		String address = request.getParameter("address");
		o.setAddress(address);
		String info = request.getParameter("info");
		o.setInfo(info);
		o.setId(id);
		orderDao.update(o);
		model.addAttribute("successMessage", "修改成功");
		Order order = orderDao.selectById(id);
		model.addAttribute("order", order);
		return "admin/pages/order-update";
	}
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ShopDao shopDao;
	@RequestMapping("/admin/toOrderAdd")
	public String toOrderAdd(HttpServletRequest request,Model model){
		List<User> user = userDao.selectAll();
		List<Shop> shop = shopDao.selectAll();
		model.addAttribute("userList", user);
		model.addAttribute("shopList", shop);
		return "admin/pages/order-add";
	}
	
	@RequestMapping(value = "/admin/addOrder",method=RequestMethod.POST)
	public String addOrder(HttpServletRequest request,Model model){
		Order order = buildOrder(request);
		orderDao.add(order);
		model.addAttribute("successMessage", "添加成功");
		return "admin/pages/order-add";
	}

	private Order buildOrder(HttpServletRequest request) {
		Order order = new Order();
		
		String numberstr = request.getParameter("number");
		order.setNumber(numberstr);
		
		String shopidstr = request.getParameter("shopid");
		int shopid = Integer.parseInt(shopidstr);
		order.setShopId(shopid);
		
		String shopCount = request.getParameter("shopCount");
		int shopcount = Integer.parseInt(shopCount);
		order.setShopCount(shopcount);
		
		String pricestr = request.getParameter("price");
		double price = Double.parseDouble(pricestr);
		order.setPrice(price);
		String address = request.getParameter("address");
		order.setAddress(address);
		String info = request.getParameter("info");
		order.setInfo(info);
		String useridstr = request.getParameter("userid");
		int userid = Integer.parseInt(useridstr);
		order.setUserId(userid);
		order.setTime(new Date());
		return order;
	}
	
	
}
