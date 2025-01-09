package com.fk.mybatisplus_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.*;
@TableName("t_user")
public class T_User {
    @TableId(type = IdType.AUTO)
    private int id;
    private String username;
    private String password;
    private String birthday;

    //这个属性在表里是不存在的，表里只有上面四个用户属性
    //告诉mybatis 这个字段是不存在的，如果不告诉这个信息 查询的时候就会查询orders 但是表里面没有
    @TableField(exist = false)
    private List<Order> orders;

    public T_User() {
    }

    public T_User(int id, String username, String password, String birthday, List<Order> orders) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.orders = orders;
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

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return orders
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * 设置
     * @param orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String toString() {
        return "T_User{id = " + id + ", username = " + username + ", password = " + password + ", birthday = " + birthday + ", orders = " + orders + "}";
    }
    //怎么映射这个字段呢？用户-订单


}
