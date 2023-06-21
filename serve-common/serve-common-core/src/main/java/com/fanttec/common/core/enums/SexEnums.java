package com.fanttec.common.core.enums;

import lombok.Getter;

/**
 * 性别枚举
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时58分02秒
 **/
@Getter
public enum SexEnums {

    MALE(1, "男"),
    FEMALE(2, "女");

    private final int code;

    private final String label;

    SexEnums(int code,String label) {
        this.code = code;
        this.label = label;
    }
}
