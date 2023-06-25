package com.fanttec.common.core.exception.job;

import com.fanttec.common.core.enums.TaskExceptionEnums;
import lombok.Getter;

import java.io.Serial;

/**
 * 计划策略异常
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时29分08秒
 **/
@Getter
public class TaskException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    private final TaskExceptionEnums taskExceptionEnums;

    public TaskException(String msg, TaskExceptionEnums taskExceptionEnums) {
        this(msg, taskExceptionEnums, null);
    }

    public TaskException(String msg, TaskExceptionEnums taskExceptionEnums, Exception nestedEx) {
        super(msg, nestedEx);
        this.taskExceptionEnums = taskExceptionEnums;
    }

}