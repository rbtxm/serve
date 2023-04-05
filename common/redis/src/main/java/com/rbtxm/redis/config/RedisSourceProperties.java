package com.rbtxm.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * @Author: guanxiangkai
 * @Description:
 * @Data: 2023年03月29日 周三 16时33分23秒
 **/
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisSourceProperties {

    private LinkedHashMap<String, RedisSourceProperty> redisSources;
    // 父连接配置

    @Data
    public static class RedisSourceProperty {
        private String host;
        private Integer port;
        private String username;
        private String password;
        private Integer database;
        // 子连接配置

    }
}
