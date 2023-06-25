package com.fanttec.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 任务异常枚举
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月25日 星期日 11时36分12秒
 **/
@Getter
@AllArgsConstructor
public enum TaskExceptionEnums {
    TASK_EXISTS(1,"任务已存在"),
    NO_TASK_EXISTS(2,"任务不存在"),
    TASK_ALREADY_STARTED(3,"任务已启动"),
    UNKNOWN(4,"未知错误"),
    CONFIG_ERROR(5,"参数配置错误"),
    TASK_NODE_NOT_AVAILABLE(6,"任务节点不可用");

    private final int code;
    private final String label;
}
