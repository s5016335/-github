package com.example.jiancheng.sql;

/**
 * Created by jiancheng on 2018/4/6.
 */

public class User {
    private String name,phone;

    public User() {
    }

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
