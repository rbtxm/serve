package com.fanttec.common.core.exception;

import java.io.Serial;

/**
 * 验证码错误异常类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
public class CaptchaException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public CaptchaException(String msg)
    {
        super(msg);
    }
}
