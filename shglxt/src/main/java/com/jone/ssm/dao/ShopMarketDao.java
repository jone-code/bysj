/*
 * @(#)ShopMarketDao.java 2018年4月28日下午4:26:20 Test Copyright 2018 Thuisoft, Inc.
 * All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 */
package com.jone.ssm.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jone.ssm.pojo.ShopMarket;


/*
 * import java.util.List;
 * 
 * ShopMarketDao
 * 
 * @author huayu
 * 
 * @version 1.0
 */
public interface ShopMarketDao {
    List<ShopMarket> selectAll();

    void update(ShopMarket market);

    void delete(@Param("id")int id);

    void add(@Param("market")ShopMarket market);
}
