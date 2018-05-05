package com.jone.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jone.ssm.pojo.Announcement;

public interface AnnouncementDao {
	List<Announcement> selectAll();
	void insert(@Param("theme")String theme,@Param("information")String information);
	void delete(@Param("id")int id);
}
