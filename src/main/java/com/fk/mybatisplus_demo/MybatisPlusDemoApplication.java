package com.fk.mybatisplus_demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication

@MapperScan("com.fk.mybatisplus_demo.mapper")
//会扫面mapper 包 找到Usermapper
public class MybatisPlusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDemoApplication.class, args);
    }

}
