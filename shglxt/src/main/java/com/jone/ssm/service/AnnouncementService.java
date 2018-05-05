package com.jone.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jone.ssm.dao.AnnouncementDao;
import com.jone.ssm.pojo.Announcement;

@Service
public class AnnouncementService {

	@Autowired
	private AnnouncementDao announcementDao;
	
	public List<Announcement> getAll(){
		return announcementDao.selectAll();
	}
	
	public void deleteById(int id){
		announcementDao.delete(id);
	}
	
	public void insert(String theme,String information){
		announcementDao.insert(theme, information);
	}
}
