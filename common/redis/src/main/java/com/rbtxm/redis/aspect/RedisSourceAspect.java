package com.rbtxm.redis.aspect;

import com.rbtxm.redis.DynamicRedisSource;
import com.rbtxm.redis.annotation.RedisSource;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: guanxiangkai
 * @Description:
 * @Data: 2023年03月29日 周三 14时58分03秒
 **/
@Slf4j
@Aspect
@Component
public class RedisSourceAspect {

    @Resource
    private RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.rbtxm.redis.annotation.RedisSource)")
    public void redisPointCut() {
    }

    @Around("redisPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        RedisSource redisSource = signature.getMethod().getAnnotation(RedisSource.class);
        RedisConnectionFactory redisConnectionFactory = DynamicRedisSource.getRedisSource(redisSource.value());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return point.proceed();
    }
}

