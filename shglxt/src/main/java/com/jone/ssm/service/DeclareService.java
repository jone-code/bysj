package com.jone.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jone.ssm.dao.DeclareDao;
import com.jone.ssm.pojo.DeclareDto;

@Service
public class DeclareService {

	@Autowired
	private DeclareDao declareDao;
	
	public List<DeclareDto> getDeclareByStatu3(int statu){
		return declareDao.selectByStatu3(statu);
	}
	
	public List<DeclareDto> getDeclareByStatu12(int statu){
		return declareDao.selectByStatu12(statu);
	}

	public void updateStatu(int id) {
		declareDao.updateStatu(id);
	}
	
}
