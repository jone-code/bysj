package com.jone.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jone.ssm.pojo.Admin;
import com.jone.ssm.pojo.Shop;
import com.jone.ssm.service.AdminService;
import com.jone.ssm.service.ShopService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin/adminLogin")
	public String adminLogin(HttpServletRequest request, Model model) {
		String adminId = request.getSession().getAttribute("adminId") + "";
		if (StringUtils.isNotEmpty(adminId) && !"null".equals(adminId)) {
			return "admin/main";
		}
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (checkAdmin(name, password)) {
			model.addAttribute("adminMessage", "信息项为空");
			return "admin/login";
		} else {
			Admin admin = adminService.selectAdmin(name, password);
			if (null != admin) {
				request.getSession().setAttribute("adminId", admin.getId());
				request.getSession().setAttribute("adminName", admin.getName());
				return "admin/main";
			} else {
				model.addAttribute("adminMessage", "用户名密码错误");
				return "admin/login";
			}
		}

	}

	@RequestMapping("/admin/adminLogout")
	public String adminLogout(HttpServletRequest request) {
		request.getSession().removeAttribute("adminId");
		request.getSession().removeAttribute("adminName");
		return "admin/login";
	}

	private boolean checkAdmin(String name, String password) {
		boolean flag = false;
		if (StringUtils.isEmpty(name)) {
			flag = true;
		}
		if (StringUtils.isEmpty(password)) {
			flag = true;
		}
		return flag;
	}

	@RequestMapping(value = "/admin/adminAdd", method = RequestMethod.POST)
	public String adminAdd(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (checkAdmin(name, password)) {
			model.addAttribute("errorMessage", "信息项为空");
		} else {
			if (hasAdmin(name)) {
				model.addAttribute("errorMessage", "用户名已存在");
			} else {
				adminService.insertAdmin(name, password);
				model.addAttribute("successMessage", "添加成功");
			}
		}
		return "admin/pages/admin-add";
	}

	private boolean hasAdmin(String name) {
		return adminService.hasAdmin(name);
	}

	@RequestMapping("/admin/toUpdatePwd")
	public String toUpdatePwd(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		model.addAttribute("name", name);
		return "admin/pages/admin-update";
	}

	@RequestMapping(value = "/admin/adminUpdate", method = RequestMethod.POST)
	public String updatePwd(HttpServletRequest request, Model model) {
		String name = (String) request.getParameter("name");
		String old = (String) request.getParameter("old");

		Admin admin = adminService.selectAdmin(name, old);
		String newOne = (String) request.getParameter("newOne");
		String newTwo = (String) request.getParameter("newTwo");
		if (StringUtils.isEmpty(newOne) || StringUtils.isEmpty(newTwo)
				|| !newOne.equals(newTwo)) {
			model.addAttribute("errorMessage", "信息项为空或者两次新密码不一致");

		} else if (null == admin) {
			model.addAttribute("errorMessage", "旧密码不正确");
		} else {
			adminService.updateAdmin(name, newOne);
			model.addAttribute("successMessage", "修改成功");
		}
		return "admin/pages/admin-update";
	}

	@RequestMapping("/admin/adminList")
	public String getAllAdmin(Model model) {
		List<Admin> list = adminService.selectAll();
		model.addAttribute("adminList", list);
		return "admin/pages/admin-list";
	}

	@RequestMapping("/admin/adminDelete")
	public String deleteAdminById(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		adminService.deleteById(Integer.parseInt(id));
		List<Admin> list = adminService.selectAll();
		model.addAttribute("adminList", list);
		return "admin/pages/admin-list";

	}
}
