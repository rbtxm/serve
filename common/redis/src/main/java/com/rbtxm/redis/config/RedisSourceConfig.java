package com.rbtxm.redis.config;

import com.rbtxm.redis.DynamicRedisSource;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Configuration
@EnableAspectJAutoProxy
public class RedisSourceConfig {

    @Resource
    private RedisSourceProperties redisSourceProperties;

    @Bean
    public DynamicRedisSource redisConnectionFactory() {
        DynamicRedisSource dynamicRedisSource = new DynamicRedisSource();
        LinkedHashMap<String, RedisSourceProperties.RedisSourceProperty> redisSources = redisSourceProperties.getRedisSources();
        if(redisSources.size()<1){
            log.error("redis配置错误,未查询到redis配置信息");
            return dynamicRedisSource;
        }
        Map<String, RedisConnectionFactory> redisSourceMap = new HashMap<>();
        redisSources.forEach((k, v) -> {
            LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
            connectionFactory.setHostName(v.getHost());
            connectionFactory.setPort(v.getPort());
            connectionFactory.setPassword(v.getPassword());
            connectionFactory.setDatabase(v.getDatabase());
            connectionFactory.afterPropertiesSet();
            redisSourceMap.put(k, connectionFactory);
        });
        dynamicRedisSource.setTargetRedisSources(redisSourceMap);
        // 默认选中第一个数据源
        String firstKey = redisSourceMap.keySet().iterator().next();
        dynamicRedisSource.setDefaultTargetRedisSource(redisSourceMap.get(firstKey));
        return dynamicRedisSource;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(DynamicRedisSource.getDefaultRedisSource());
        return redisTemplate;
    }


}
