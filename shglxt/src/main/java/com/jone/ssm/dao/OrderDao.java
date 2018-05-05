package com.jone.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jone.ssm.pojo.Order;
import com.jone.ssm.pojo.OrderDto;

public interface OrderDao {
	List<OrderDto> selectAll();
	void deleteById(@Param("id")int id);
	void add(@Param("order")Order order);
	void update(@Param("order")Order order);
	Order selectById(@Param("id")int id);
}
