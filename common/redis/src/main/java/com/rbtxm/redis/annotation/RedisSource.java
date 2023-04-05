package com.rbtxm.redis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: guanxiangkai
 * @Description:
 * @Data: 2023年04月03日 周一 16时10分27秒
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisSource {
    String value() default "defaultDataSource";
}
