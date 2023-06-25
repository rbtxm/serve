package com.fanttec.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请求方式
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时49分17秒
 **/
@Getter
@AllArgsConstructor
public enum HttpTypeEnums {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private final String value;
}
