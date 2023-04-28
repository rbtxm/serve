package com.rbtxm.datasource.aspect;

import com.rbtxm.datasource.annotation.DataSource;
import com.rbtxm.datasource.holder.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月28日  15时57分37秒
 **/
@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {
    @Pointcut("@annotation(com.rbtxm.datasource.annotation.DataSource)")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSource dataSource = signature.getMethod().getAnnotation(DataSource.class);
        if (dataSource == null) {
            DynamicDataSourceContextHolder.setDataSource("default");
        } else {
            DynamicDataSourceContextHolder.setDataSource(dataSource.value());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSourceContextHolder.clearDataSource();
        }
    }
}
