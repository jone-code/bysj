package com.jone.ssm.pojo;

public class ShopDto {
	private int id;
	private String shopNum;
	private String name;
	private double price;
	private int count;
	private String  image;
	private String className;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopNum() {
		return shopNum;
	}
	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
