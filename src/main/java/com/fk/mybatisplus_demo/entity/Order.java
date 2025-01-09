package com.fk.mybatisplus_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private int id;
    private String order_time;
    private double total;
    private int uid;

    @TableField(exist = false)
    private T_User t_user; //一对一关系


    public Order() {
    }

    public Order(int id, String order_time, double total, int uid, T_User t_user) {
        this.id = id;
        this.order_time = order_time;
        this.total = total;
        this.uid = uid;
        this.t_user = t_user;
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
     * @return order_time
     */
    public String getOrder_time() {
        return order_time;
    }

    /**
     * 设置
     * @param order_time
     */
    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    /**
     * 获取
     * @return total
     */
    public double getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * 获取
     * @return uid
     */
    public int getUid() {
        return uid;
    }

    /**
     * 设置
     * @param uid
     */
    public void setUid(int uid) {
        this.uid = uid;
    }

    /**
     * 获取
     * @return t_user
     */
    public T_User getT_user() {
        return t_user;
    }

    /**
     * 设置
     * @param t_user
     */
    public void setT_user(T_User t_user) {
        this.t_user = t_user;
    }

    public String toString() {
        return "Order{id = " + id + ", order_time = " + order_time + ", total = " + total + ", uid = " + uid + ", t_user = " + t_user + "}";
    }
}
