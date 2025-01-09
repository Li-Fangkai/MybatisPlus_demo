package com.fk.mybatisplus_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//传统EE开发设置过滤器配置 spring boot提供简洁方案
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //允许跨域访问的路径
        .allowedOriginPatterns("*") //允许跨域访问的源
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")//允许的请求
        .maxAge(13600) //预检间隔
        .allowedHeaders("*") //允许头部设置
        .allowCredentials(true); //允许发送cookie
    }
}
