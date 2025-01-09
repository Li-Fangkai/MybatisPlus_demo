package com.fk.mybatisplus_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fk.mybatisplus_demo.entity.Order;
import com.fk.mybatisplus_demo.entity.T_User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from t_order where uid=#{uid}")
    List<Order> findByUid(int uid);//根据uid查询出来的订单是列表


    //允许ordermapper调用usermapper
    //查询所有订单及其用户
    @Select("select * from t_order")
    @Results(
            {
                    @Result(column = "id",property = "id"),
                    @Result(column = "ordertime",property = "ordertime"),
                    @Result(column = "total",property = "total"),
                    @Result(column = "uid",property = "uid"),
                    //根据订单表查出来的uid 使用tusermapper的byid方法查找用户.返回的是tuser对象
                    @Result(column = "uid",property = "t_user",javaType = T_User.class,//赋值给order的t_user属性 指出类型
                            one=@One(select="com.fk.mybatisplus_demo.mapper.T_UserMapper.selectById")
                    )//一个订单一个用户 所以用one
            }
    )
    List<Order> selectAllOrderAndUser();

}
