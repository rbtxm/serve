package com.fanttec.common.core.exception;

import java.io.Serial;

/**
 * 工具类异常
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 17时01分59秒
 **/
public class UtilException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 8247610319171014183L;

    public UtilException(Throwable e) {
        super(e.getMessage(), e);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
