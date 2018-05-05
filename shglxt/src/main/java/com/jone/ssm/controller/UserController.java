package com.jone.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jone.ssm.pojo.Shop;
import com.jone.ssm.pojo.User;
import com.jone.ssm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/admin/toUserList")
	public String toUserList(Model model) {
		List<User> list = userService.selectAll();
		model.addAttribute("userList", list);
		return "admin/pages/user-list";
	}

	@RequestMapping("/admin/updateUser")
	public String updateUser(HttpServletRequest request, Model model) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User user = userService.selectUserById(id);
		model.addAttribute("user", user);
		return "admin/pages/user-update";
	}

	@RequestMapping("/admin/deleteUser")
	public String deleteUser(HttpServletRequest request, Model model) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		userService.deleteUser(id);
		List<User> list = userService.selectAll();
		model.addAttribute("userList", list);
		return "admin/pages/user-list";
	}

	@RequestMapping("/admin/resetUser")
	public String resetUser(HttpServletRequest request, Model model) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		userService.resetUser(id);
		List<User> list = userService.selectAll();
		model.addAttribute("userList", list);
		return "admin/pages/user-list";
	}

	@RequestMapping("/admin/userUpdatePhone")
	public String userUpdatePhone(HttpServletRequest request, Model model) {
		String idStr = request.getParameter("id");
		String phone = request.getParameter("phone");
		int id = Integer.parseInt(idStr);
		userService.updatePhone(id,phone);
		List<User> list = userService.selectAll();
		model.addAttribute("userList", list);
		return "admin/pages/user-list";
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
	/**
	 * 判断是否有用户
	 * @param name
	 * @return
	 */
	private boolean hasUser(String name) {
		return userService.hasUser(name);
	}
	
	@RequestMapping("/admin/pages/userAdd")
	public String userAdd(HttpServletRequest request, Model model){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		if(checkUser(name, password, phone)){
			if(hasUser(name)){
				model.addAttribute("message","用户已存在");
				return "admin/pages/user-add";
			}
			userService.addUser(name,password,phone);
			/*List<User> users = userService.existUser(name, password);
			request.getSession().setAttribute("id",users.get(0).getId());
			request.getSession().setAttribute("name", name);
			List<User> list = userService.selectAll();
			model.addAttribute("userList", list);*/
			model.addAttribute("successMessage","添加成功");
			return "admin/pages/user-add";
		}else{
			model.addAttribute("message","信息项不能为空");
			return "admin/pages/user-add";
		}
	}

}
