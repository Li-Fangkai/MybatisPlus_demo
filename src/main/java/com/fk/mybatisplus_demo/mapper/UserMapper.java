package com.fk.mybatisplus_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;//plus里面的
import com.fk.mybatisplus_demo.entity.User1;
import org.apache.ibatis.annotations.Mapper;//ibatis是早期名称
import org.apache.ibatis.annotations.*;
import org.apache.tomcat.websocket.BackgroundProcess;

import java.util.*;
@Mapper //表示这是一个mapper组件
public interface UserMapper extends BaseMapper<User1> {//这里类名必须和数据库表名一致
    //接口继承baseMapper<User1>
    //使用注解直接进行查询，会从对应数据库的表里查询
    //查询结果自动放在list里面
//   @Select("select * from user")
//   List<User1> findAll ();//接口方法默认public
//
//    @Select("select * from user where id=#{id}")
//    User1 findById (int id);
//
//    //这里插入的数据应该来自对象，用#
//   @Insert("insert into user values(#{id}, #{name},#{phone})")
//    int add(User1 user);//返回值为int 表示插入了几条数据 如果插入失败 返回0
//
//   @Update("update user set name=#{name} where id=#{id}")
//   int update(User1 user);//一定要保证类里面有name phone 这些属性名称
//
//   @Delete("delete from user where id=#{id}")
//    int delete(int id);


   //使用mybatis-plus条件下，可以进一步简化
    //使用plus 继承BaseMapper<类名>
    //这样，BaseMapper会自动找到user表，直接进行增删改查
}
