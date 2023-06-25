package com.fanttec.common.core.exception;

import java.io.Serial;

/**
 * 内部认证异常
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 17时01分59秒
 **/
public class InnerAuthException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InnerAuthException(String message) {
        super(message);
    }
}
