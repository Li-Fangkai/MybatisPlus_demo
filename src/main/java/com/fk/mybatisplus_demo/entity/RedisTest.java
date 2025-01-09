package com.fk.mybatisplus_demo.entity;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

public class RedisTest {
    private static final String REDIS_KEY = "user";
    //REDIS_KEY 常量为存储用户信息到 Redis 的 key
    public static void main(String[] args) {
        //在 Jedis 的帮助下，Java 连接 Redis 服务变得非常简单，只需要一行代码
//        Gson 是谷歌提供的一个开源库，可以将 Java 对象序列化为 JSON 字符串
//        同样可以将 JSON 字符串反序列化（解析）为匹配的 Java 对象
//        使用起来也非常简单，toJson() 方法将对象转成 JSON 字符串，fromJson() 方法将 JSON 字符串反序列化对象
        Jedis jedis = new Jedis("localhost", 6379);

        Gson gson = new Gson();
        UserInfo userInfo = new UserInfo("沉默王二", 18);

        jedis.set(REDIS_KEY, gson.toJson(userInfo));
        UserInfo getUserInfoFromRedis = gson.fromJson(jedis.get(REDIS_KEY),UserInfo.class);

        System.out.println("get：" + getUserInfoFromRedis);

        System.out.println("exists：" + jedis.exists(REDIS_KEY));
        System.out.println("del：" + jedis.del(REDIS_KEY));
        System.out.println("get：" + jedis.get(REDIS_KEY));
    }
}