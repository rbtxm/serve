package com.rbtxm.datascope.enums;

import lombok.Getter;

/**
 * 数据权限枚举
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月11日  18时49分08秒
 **/
@Getter
public enum DataScopeTypeEnum {
    // 全部
    ALL,
    // 仅本人
    SELF,
    // 本部门
    DEPT,
    // 本部门及子部门
    DEPT_AND_CHILD,
    // 自定义
    CUSTOM
}
