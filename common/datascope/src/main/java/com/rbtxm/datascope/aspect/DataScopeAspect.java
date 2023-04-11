package com.rbtxm.datascope.aspect;

import com.rbtxm.datascope.annotation.DataScope;
import com.rbtxm.datascope.constant.DataScopeConstant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Slf4j
@Aspect
public class DataScopeAspect {


    @Before("@annotation(controllerDataScope)")
    public void doBefore(JoinPoint point, DataScope controllerDataScope){
     // 拼接查询条件 定义常量
        String dataScope = DataScopeConstant.DATA_SCOPE;
    }

}

