package com.fk.mybatisplus_demo.controller;

import com.fk.mybatisplus_demo.User;
import com.fk.mybatisplus_demo.entity.User1;
import com.fk.mybatisplus_demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController//restful注解
public class UserController {

    @Autowired//注入userMapper ，会自动把UserMapper所实例出来的对象进行自动注入
    private UserMapper userMapper; //如果没有注入 则这个属性对象就是空的

    @GetMapping("/user")
    public List<User1> query() {
        //spring会自动实例化UserMapper，无需手动实现接口
        //会自动管理实例，动态代理的方式生成了一个实现类，并实现了UserMapper接口
        //List<User1> list = userMapper.findAll();//返回的对象会自动转为json 是自动完成的
        List<User1> list = userMapper.selectList(null);//basemapper提供的
        System.out.println(list);
        //return "查询用户";
        return list;
    }

    @PostMapping("/userbyId")
    public User1 selectById( String id) {
        //User1 user = userMapper.findById(id);
        User1 user =userMapper.selectById(id);//来自baseMapper的方法
        return user;
    }

    @PostMapping("/user") //往数据库里面插入数据 需要使用post请求
    public String save(User1 user) {
//        int i = userMapper.add(user);
        int i=userMapper.insert(user);
        System.out.println(user);
        if (i > 0) {
            return "success save!";
        } else {
            return "fail save!";
        }
    }
    @PostMapping("/userdelete") //根据ID删除数据
    public String delete(int id){
//        int i= userMapper.delete(id);
        int i=userMapper.deleteById(id);
        if (i > 0) {
            return "success delete!";
        }else{
            return "fail delete!";
        }
    }

    @PostMapping("/userupdate") //根据ID更新数据
    public String update(User1 user){
//        int i= userMapper.update(user);
        int i=userMapper.updateById(user);
        if (i > 0) {
            return "success update!";
        }else{
            return "fail update!";
        }
    }
}
