package com.fk.mybatisplus_demo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;


@Configuration//配置类注解
public class MyBatisPlusConfig {


    //page拦截器
    @Bean
    public MybatisPlusInterceptor paginationInterception(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();//创建一个mybatis拦截器
        PaginationInnerInterceptor pagerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);//告诉数据库类型
        interceptor.addInnerInterceptor(pagerInterceptor);//拦截器注册
        return interceptor;

    }
}
