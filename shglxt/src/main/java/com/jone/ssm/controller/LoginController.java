package com.jone.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jone.ssm.pojo.Shop;
import com.jone.ssm.pojo.User;
import com.jone.ssm.service.ShopService;
import com.jone.ssm.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginPage")
	public String loginPage(){
		return "index/login";
	}
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value ="/register",method = RequestMethod.POST)
	public String register(HttpServletRequest request,Model model){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		if(checkUser(name, password, phone)){
			if(hasUser(name)){
				model.addAttribute("message","用户已存在");
				return "index/register";
			}
			userService.addUser(name,password,phone);
			List<User> users = userService.existUser(name, password);
			request.getSession().setAttribute("id",users.get(0).getId());
			request.getSession().setAttribute("name", name);
			List<Shop> list = shopService.selectAll();
			model.addAttribute("shopList",list);
			return "index/index";
		}else{
			model.addAttribute("message","信息项不能为空");
			return "index/register";
		}
		
	}
	
	/**
	 * 判断是否有用户
	 * @param name
	 * @return
	 */
	private boolean hasUser(String name) {
		return userService.hasUser(name);
	}

	private boolean checkUser(String name,String password,String phone){
		boolean flag = true;
		if(StringUtils.isEmpty(name)){
			flag = false;
		}
		if(StringUtils.isEmpty(password)){
			flag = false;
		}
		if(StringUtils.isEmpty(phone)){
			flag = false;
		}
		return flag;
	}
	
	@RequestMapping(value ="/login",method = RequestMethod.POST)
	public String  login(String name,String password,HttpServletRequest request,Model model){
		List<User> users = userService.existUser(name, password);
		if(CollectionUtils.isNotEmpty(users)){
			request.getSession().setAttribute("id",users.get(0).getId());
			request.getSession().setAttribute("name", name);
			List<Shop> list = shopService.selectAll();
			model.addAttribute("shopList",list);
			return "index/index";
		}else{
			model.addAttribute("message","登录失败");
			return "index/login";
		}
	}
	
	
	@RequestMapping("/updatepwd")
	public String toUpdatePwd(Model model){
		model.addAttribute("isupdatepwd",true);
		return "index/index";
	}
	@RequestMapping(value="/updatePassword")
	@ResponseBody
	public String updatePwd(HttpServletRequest request) throws UnsupportedEncodingException{
		String name = (String) request.getSession().getAttribute("name");
		String old = (String)request.getParameter("old");
		
		boolean isTrue = userService.selectUser(name,old);
		String newOne = (String)request.getParameter("newOne");
		String newTwo = (String)request.getParameter("newTwo");
		if(StringUtils.isEmpty(newOne)||StringUtils.isEmpty(newTwo)||!newOne.equals(newTwo)){
			return "1";
		}else if(!isTrue){
			return "2";
		}else{
			userService.updateUser(name,newOne);
			return "200";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,Model model){
		request.getSession().removeAttribute("name");
		List<Shop> list = shopService.selectAll();
		model.addAttribute("shopList",list);
		return "index/index";
	}
	
	@RequestMapping("/register")
	public String register(){
		return "index/register";
	}
	
	
	
}
