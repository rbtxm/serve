package com.fanttec.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户来源枚举
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 17时03分56秒
 **/
@Getter
@AllArgsConstructor
public enum UserSourceEnums {

    SYSTEM(1, "系统"),
    WECHAT(2, "微信"),
    QQ(3, "QQ"),
    ALIPAY(4, "支付宝"),
    DINGTALK(5, "钉钉"),
    MINI_PROGRAM(6, "小程序"),
    APP(7, "app"),
    OTHER(8, "其他");

    private final int code;

    private final String label;

}
