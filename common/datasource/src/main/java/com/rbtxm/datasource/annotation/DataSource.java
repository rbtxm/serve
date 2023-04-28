package com.rbtxm.datasource.annotation;

import java.lang.annotation.*;

/**
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月28日  15时55分25秒
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value() default "default";
}
