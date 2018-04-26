package com.jone.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jone.ssm.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginPage")
	public String loginPage(){
		return "index/login";
	}
	
	@RequestMapping(value ="/login",method = RequestMethod.POST)
	public ModelAndView  login(String name,String password,HttpServletRequest request){
		boolean isExist = userService.existUser(name, password);
		ModelAndView mav = new ModelAndView(); 
		if(isExist){
			request.getSession().setAttribute("name", name);
			mav.setViewName("index/index");
			return mav;
		}else{
			request.getSession().setAttribute("status", "登录失败");
			mav.setViewName("redirect:/login");
			return mav;
		}
	}
	
	@RequestMapping("/register")
	public String register(){
		return "index/register";
	}
	
}
