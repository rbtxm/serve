package com.fanttec.common.core.exception.auth;

import java.io.Serial;

/**
 * 未能通过的登录认证异常
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
public class NotLoginException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NotLoginException(String message)
    {
        super(message);
    }
}
