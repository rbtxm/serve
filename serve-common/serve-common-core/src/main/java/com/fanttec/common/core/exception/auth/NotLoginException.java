package com.fanttec.common.core.exception.auth;

import java.io.Serial;

/**
 * 未能通过的登录认证异常
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时29分08秒
 **/
public class NotLoginException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NotLoginException(String message) {
        super(message);
    }
}
