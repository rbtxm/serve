package com.fanttec.common.core.enums;

import lombok.Getter;

/**
 * 请求方式
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时49分17秒
 **/
@Getter
public enum HttpTypeEnums {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private final String value;

    HttpTypeEnums(String value) {
        this.value = value;
    }
}
