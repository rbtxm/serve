package com.rbtxm.redis;


import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class DynamicRedisSource {

    private static Map<String, RedisConnectionFactory> redisSourceMap = new LinkedHashMap<>();

    private static RedisConnectionFactory defaultRedisSource = new LettuceConnectionFactory();


    public static void setTargetRedisSources(Map<String, RedisConnectionFactory> redisConnectionFactoryMap) {
        redisSourceMap = redisConnectionFactoryMap;
    }

    public static void setDefaultTargetRedisSource(RedisConnectionFactory redisConnectionFactory) {
        defaultRedisSource = redisConnectionFactory;
    }

    public static RedisConnectionFactory getRedisSource(String key) {
        if (redisSourceMap.containsKey(key)) {
            return redisSourceMap.get(key);
        }
        return defaultRedisSource;
    }

    public static RedisConnectionFactory getDefaultRedisSource() {
        return defaultRedisSource;
    }
}
