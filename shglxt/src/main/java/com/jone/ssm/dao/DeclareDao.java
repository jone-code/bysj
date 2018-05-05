/*
 * @(#)DeclareDao.java 2018年4月28日下午4:50:27 Test Copyright 2018 Thuisoft, Inc.
 * All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 */
package com.jone.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jone.ssm.pojo.Declare;
import com.jone.ssm.pojo.DeclareDto;


/*
 * 
 * DeclareDao
 * 
 * @author huayu
 * 
 * @version 1.0
 */
public interface DeclareDao {
    List<Declare> selectAll();

    List<Declare> selectAllByUser(@Param("userId") int usrId);

    void updateDeclare(Declare declare);

    void deleteById(@Param("id")int id);

    void add(@Param("declare")Declare declare);
    
    List<DeclareDto> selectByStatu3(@Param("statu")int statu);
    List<DeclareDto> selectByStatu12(@Param("statu")int statu);

	void updateStatu(@Param("id")int id);
    
}
