/*
 * @(#)DeclareController.java 2018年4月28日下午4:46:00 Test Copyright 2018 Thuisoft,
 * Inc. All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject
 * to license terms.
 */
package com.jone.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jone.ssm.dao.DeclareDao;
import com.jone.ssm.pojo.Declare;
import com.jone.ssm.pojo.DeclareDto;
import com.jone.ssm.service.DeclareService;

/**
 * DeclareController
 * 
 * @author huayu
 * @version 1.0
 * 
 */
@Controller
public class DeclareController {

	@Autowired
	private DeclareDao declareDao;

	@RequestMapping("/getDeclareByUser")
	public String getDeclareByUser(HttpServletRequest request, Model model) {
		String id = (String) request.getSession().getAttribute("id");
		Integer in = Integer.parseInt(id);
		List<Declare> list = declareDao.selectAllByUser(in);
		model.addAttribute("declareList", list);
		return "index/index";
	}
	@RequestMapping("/deleteDeclare")
	public String deleteDeclare(HttpServletRequest request, Model model){
		String useridstr=request.getParameter("id");
		int userid = Integer.parseInt(useridstr);
		declareDao.deleteById(userid);
		String idStr = (String) request.getSession().getAttribute("id");
		int id = Integer.parseInt(idStr);
		List<Declare> list = declareDao.selectAllByUser(id);
		model.addAttribute("declareList", list);
		return "index/index";
	}
	
	
	@RequestMapping("/toAddDeclareByUser")
	public String toAddDeclareByUser(Model model){
		model.addAttribute("isAddDeclare",true);
		return "index/index";
	}
	
	@RequestMapping("/updateDeclare")
	@ResponseBody
	public String updateDeclare(HttpServletRequest request){
		String idStr = (String) request.getSession().getAttribute("id");
		int id = Integer.parseInt(idStr);
		String theme = request.getParameter("d_theme");
		String info = request.getParameter("d_info");
		Declare declare = new Declare(id, theme, info, 1);
		declareDao.add(declare);
		return "ok";
	}
	
	@Autowired
	private DeclareService declareService;
	
	@RequestMapping("/admin/declareList")
	public String getDeclareByStatu(HttpServletRequest request, Model model){
		String statu = request.getParameter("statu");
		int s = Integer.parseInt(statu);
		List<DeclareDto> list = new ArrayList<DeclareDto>();
		if(s==0){
			list = declareService.getDeclareByStatu12(3);
		}else if(s==3){
			list = declareService.getDeclareByStatu3(3);
		}
		model.addAttribute("declareList", list);
		return "admin/pages/declare-list";
	}
	
	
	@RequestMapping("/admin/updateStatu")
	public String updateStatu(HttpServletRequest request,Model model) {
		String idStr = request.getParameter("id");
		int id =Integer.parseInt(idStr);
		declareService.updateStatu(id);
		List<DeclareDto> list = declareService.getDeclareByStatu12(3);
		model.addAttribute("declareList", list);
		return "admin/pages/declare-list";
	}
	
}
