package com.fk.mybatisplus_demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fk.mybatisplus_demo.entity.T_User;
import com.fk.mybatisplus_demo.mapper.T_UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class T_UserController {

    @Autowired
    private T_UserMapper t_userMapper;


    @PostMapping("user/findById")
    public T_User findById(int id) {
        return t_userMapper.selectById(id);
    }

    @GetMapping("/user/findAll")
    public List<T_User> guery() {
        List<T_User> list=t_userMapper.selectAllUserAndOrders();
        return list;
    }

    //条件查询示例：
    @GetMapping("user/find")
    public List<T_User> findByCondition(T_User t_user) {
        //条件查询器
        QueryWrapper<T_User> queryWrapper=new QueryWrapper<>();
        //找用户名为user1的
        queryWrapper.eq("username","user1");//列名 ，值
        return t_userMapper.selectList(queryWrapper);//把条件构造器传入basemapper的selectList（）中

    }

    //分页查询
    //数据库记录往往几万条 不可能全部展示出来需要分页返回结果
    @GetMapping("/user/findByPage")
    public IPage findByPage(T_User t_user) {
        Page<T_User> pages = new Page<>(0,2);//起始条和每页的数量
        //baseMapper提供的selectPage方法，这个方法接受两个参数：一个page对象,一个queryWrapper
        IPage iPage=t_userMapper.selectPage(pages,null);
        return iPage;//这个直接返回给前端即可 里面封装了分页查询信息
    }

}
