package com.fanttec.common.core.enums;

import lombok.Getter;

/**
 * 状态枚举
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 17时11分42秒
 **/
@Getter
public enum StatusEnums {

    ENABLE(1, "启用"),
    DISABLE(2, "禁用");

    private final int code;

    private final String label;

    StatusEnums(int code,String label) {
        this.code = code;
        this.label = label;
    }
}
