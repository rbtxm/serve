package com.rbtxm.datasource.aspect;

import com.rbtxm.datasource.DynamicDataSource;
import com.rbtxm.datasource.annotation.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.rbtxm.datasource.annotation.DataSource)")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSource dataSource = signature.getMethod().getAnnotation(DataSource.class);
        DynamicDataSource.setDataSource(dataSource.value());
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }
}

