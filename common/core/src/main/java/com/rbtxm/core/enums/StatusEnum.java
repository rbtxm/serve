package com.rbtxm.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 状态
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月11日  19时42分03秒
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusEnum {

    ENABLE("启用"),

    DISABLE("停用");

    private String dec;
}
