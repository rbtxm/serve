package com.fanttec.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 时间格式枚举
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时30分43秒
 **/
@Getter
@AllArgsConstructor
public enum DateEnums {

    DATE_FORMAT("yyyy-MM-dd"),
    DATE_TIME_FORMAT("yyyy-MM-dd HH:mm:ss"),
    TIME_FORMAT("HH:mm:ss"),
    DATE_FORMAT_CN("yyyy年MM月dd日"),
    DATE_TIME_FORMAT_CN("yyyy年MM月dd日 HH时mm分ss秒"),
    TIME_FORMAT_CN("HH时mm分ss秒"),
    YYYYMMDD("yyyyMMdd"),
    YYYYMMDDHHMMSS("yyyyMMddHHmmss");

    private final String value;

}
