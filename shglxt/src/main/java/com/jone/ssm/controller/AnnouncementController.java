package com.jone.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jone.ssm.pojo.Announcement;
import com.jone.ssm.service.AnnouncementService;

@Controller
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService;
	
	@RequestMapping("/getAllAnnouncement")
	public String getAll(Model model){
		List<Announcement> list = announcementService.getAll();
		model.addAttribute("announcementList",list);
		return "index/index";
	}
	
	@RequestMapping("/admin/announcementList")
	public String selectAll(Model model){
		List<Announcement> list = announcementService.getAll();
		model.addAttribute("announcementList",list);
		return "admin/pages/announcement-list";
	}
	
	
	
	@RequestMapping("/admin/deleteAnnouncement")
	public String deleteAnnouncement(HttpServletRequest request,Model model){
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		announcementService.deleteById(id);
		List<Announcement> list = announcementService.getAll();
		model.addAttribute("announcementList",list);
		return "admin/pages/announcement-list";
	}
	
	
	@RequestMapping("/announcementAdd")
	public String insertAnnouncement(HttpServletRequest request,Model model){
		String theme = request.getParameter("theme");
		String information = request.getParameter("information");
		announcementService.insert(theme, information);
		model.addAttribute("succsessMessage", "添加成功");
		return "admin/pages/announcement-add";
	}
	
}

