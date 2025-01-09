package com.fk.mybatisplus_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fk.mybatisplus_demo.entity.T_User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface T_UserMapper extends BaseMapper<T_User> {
    //里面基本的增删改查啥也不用写

    //但是对于多表查询 basemapper不能完成
    @Select("select * from t_user where id=#{id}")
    T_User selectById(int id);

//    @Select("select * from t_user")
//    List<T_User> selectAllUserAndOrders();



    //需要自己手动实现多表查询
    //@result注解：
    //@many注解：
    //查询用户及其所有订单
    @Select("select * from t_user")
    @Results(//这里是results注解 代替resultmap标签 可以加入多个result注解
            {
                    //@result替代<id><result>标签 Column 表示数据库字段名 property 表示类的属性名
                    //one 一对一映射 many=@Many(select=)一对多映射
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "passsword", property = "password"),
            @Result(column = "birthday", property = "birthday"),
                    //最关键的是orders
            @Result(column = "id", property = "orders", javaType = List.class,//数据库id字段映射到orders属性，并且指明类型是list
                    many = @Many(select = "com.fk.mybatisplus_demo.mapper.OrderMapper.findByUid")//调用orderMapper的方法
                    )//这里一个用户映射多个订单
                    //通过com.fk.mybatisplus_demo.mapper.OrderMapper.selectByUid
                    // 找到OrderMapper里的@Select("select * from order where uid=#{uid}")
                    //把List<Order> findByUid结果赋值给t_user的属性orders列表
            }
    )
    List<T_User> selectAllUserAndOrders();
}
