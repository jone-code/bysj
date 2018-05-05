package com.jone.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jone.ssm.pojo.Category;
import com.jone.ssm.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/admin/categoryList")
	public String getAll(Model model) {
		model.addAttribute("categoryList", categoryService.getAll());
		return "admin/pages/category-list";
	}

	@RequestMapping("/admin/deleteCategory")
	public String deleteCategory(HttpServletRequest request, Model model) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		categoryService.deleteById(id);
		model.addAttribute("categoryList", categoryService.getAll());
		return "admin/pages/category-list";
	}

	@RequestMapping("/admin/toUpdateCategory")
	public String toUpdateCategory(HttpServletRequest request, Model model) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Category category = categoryService.selectById(id);
		model.addAttribute("category", category);
		return "admin/pages/category-update";
	}

	@RequestMapping("/admin/categoryUpdate")
	public String categoryUpdate(HttpServletRequest request, Model model) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String name = request.getParameter("name");
		// 查询一下名称有没有重复
		if (categoryService.hasName(name)) {
			model.addAttribute("message", "名称重复");
			return "admin/pages/category-update";
		} else {
			categoryService.updateCategory(id, name);
			model.addAttribute("categoryList", categoryService.getAll());
			return "admin/pages/category-list";
		}
	}

	@RequestMapping("/admin/pages/categoryAdd")
	public String categoryAdd(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		// 查询一下名称有没有重复
		if (categoryService.hasName(name)) {
			model.addAttribute("message", "名称重复");
			return "admin/pages/category-add";
		} else {
			categoryService.addCategory(name);
			model.addAttribute("categoryList", categoryService.getAll());
			model.addAttribute("successMessage", "添加成功");
			return "admin/pages/category-add";
		}

	}
}
