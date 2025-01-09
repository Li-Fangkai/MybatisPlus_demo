package com.fk.mybatisplus_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user")//数据库表名和类名不一致，使用注解
public class User1 {
    @TableId(type = IdType.AUTO)//加上这个注解后，插入user不给id也能自增
    private int id;
    private String name;
    @TableField("iphone") //映射到数据库iphone字段
    private String phone;

    public User1() {
    }

    public User1(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public User1(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "User{id = " + id + " name = " + name + ", phone = " + phone + "}";
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
