/*
 * @(#)Declare.java 2018年4月28日下午4:46:20 Test Copyright 2018 Thuisoft, Inc. All
 * rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 */
package com.jone.ssm.pojo;

/**
 * Declare  申报
 * @author huayu
 * @version 1.0
 *
 */
public class Declare {
    private int id;

    private int userId;

    private String theme;

    private String information;

    private int statu;

    
    public Declare() {
		super();
	}

	public Declare(int userId, String theme, String information, int statu) {
		super();
		this.userId = userId;
		this.theme = theme;
		this.information = information;
		this.statu = statu;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

}
