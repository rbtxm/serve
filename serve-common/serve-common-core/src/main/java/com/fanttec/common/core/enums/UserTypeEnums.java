package com.fanttec.common.core.enums;

import lombok.Getter;

/**
 * 用户类型枚举
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 17时01分59秒
 **/
@Getter
public enum UserTypeEnums {

    ADMIN(1, "管理员"),
    USER(2, "用户");

    private final int code;

    private final String label;

    UserTypeEnums(int code,String label) {
        this.code = code;
        this.label = label;
    }
}
