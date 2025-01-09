package com.fk.mybatisplus_demo.controller;


import com.fk.mybatisplus_demo.entity.Order;
import com.fk.mybatisplus_demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/order/oau")
    public List<Order> findOrderAndUser() {
        return orderMapper.selectAllOrderAndUser();
    }

    @PostMapping("/order/orderbyuid")
    public List<Order> findByUid(int uid) {
        return orderMapper.findByUid(uid);
    }
}
