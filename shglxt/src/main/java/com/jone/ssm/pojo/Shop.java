package com.jone.ssm.pojo;

public class Shop {
	private int id;
	private String shopNum;
	private String name;
	private double price;
	private int count;
	private int type;
	private int shopclassId;
	private String image;
	
	
	public Shop(String shopNum, String name, double price, int count,
			int shopclassId) {
		super();
		this.shopNum = shopNum;
		this.name = name;
		this.price = price;
		this.count = count;
		this.shopclassId = shopclassId;
	}
	public Shop() {
		super();
	}
	
	public Shop(int id, String shopNum, String name, double price, int count,
			int shopclassId) {
		super();
		this.id = id;
		this.shopNum = shopNum;
		this.name = name;
		this.price = price;
		this.count = count;
		this.shopclassId = shopclassId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getShopclassId() {
		return shopclassId;
	}
	public void setShopclassId(int shopclassId) {
		this.shopclassId = shopclassId;
	}
	
	
	
}
