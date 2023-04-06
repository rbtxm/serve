package com.rbtxm.redis.config;

import org.springframework.data.redis.connection.RedisConnection;
import org.jetbrains.annotations.NotNull;

/**
 * 自定义的redisTemplate，主要是为了能够在使用过程中动态切换数据库
 * @link com.rbtxm.redis.service.RedisService#setDB(int)
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月06日  19时17分05秒
 **/
public class RedisTemplate<k, v> extends org.springframework.data.redis.core.RedisTemplate<k, v> {
    public static ThreadLocal<Integer> REDIS_DB_INDEX = new ThreadLocal<>() ;

    @Override
    protected @NotNull RedisConnection preProcessConnection(@NotNull RedisConnection connection, boolean existingConnection) {
        try {
            Integer dbIndex = REDIS_DB_INDEX.get();
            //如果设置了dbIndex
            if (dbIndex != null) {
                connection.select(dbIndex);
            }
        } finally {
            REDIS_DB_INDEX.remove();
        }
        return super.preProcessConnection(connection, existingConnection);
    }


}