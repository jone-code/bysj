package com.jone.ssm.pojo;

import java.util.Date;

public class Order {
	private int id;
	private String number;
	private int shopCount;
	private double price;
	private Date time;
	private int shopId;
	private int userId;
	private String info;
	private String address;
	public Order() {
		super();
	}
	public Order(String number, int shopCount, double price, Date time,
			int shopId, int userId, String info, String address) {
		super();
		this.number = number;
		this.shopCount = shopCount;
		this.price = price;
		this.time = time;
		this.shopId = shopId;
		this.userId = userId;
		this.info = info;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNum() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getShopCount() {
		return shopCount;
	}
	public void setShopCount(int shopCount) {
		this.shopCount = shopCount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
