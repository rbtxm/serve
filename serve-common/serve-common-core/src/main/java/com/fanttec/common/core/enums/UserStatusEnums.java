package com.fanttec.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态枚举
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 17时02分44秒
 **/
@Getter
@AllArgsConstructor
public enum UserStatusEnums {

    ACTIVE(1, "待激活"),
    NORMAL(2, "正常"),
    CANCEL(3, "注销"),
    LOCKED(4, "锁定");

    private final int code;
    private final String label;
}
