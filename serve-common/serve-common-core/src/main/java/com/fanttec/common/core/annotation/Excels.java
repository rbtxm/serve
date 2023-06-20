package com.fanttec.common.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel注解集
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时21分26秒
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excels {
    Excel[] value();
}
