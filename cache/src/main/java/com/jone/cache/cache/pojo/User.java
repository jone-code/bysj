package com.jone.cache.cache.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String cId;

    private String cName;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }
}