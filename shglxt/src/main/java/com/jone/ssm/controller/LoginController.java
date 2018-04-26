package com.jone.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String  login(String name,String password,HttpServletRequest request,Model model){
		boolean isExist = userService.existUser(name, password);
		
		if(isExist){
			request.getSession().setAttribute("name", name);
			return "index/index";
		}else{
			model.addAttribute("message","登录失败");
			return "index/login";
		}
	}
	
	@RequestMapping("/register")
	public String register(){
		return "index/register";
	}
	
}
