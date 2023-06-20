package com.fanttec.common.core.exception;

import java.io.Serial;

/**
 * 检查异常
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
public class CheckedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public CheckedException(String message)
    {
        super(message);
    }

    public CheckedException(Throwable cause)
    {
        super(cause);
    }

    public CheckedException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
