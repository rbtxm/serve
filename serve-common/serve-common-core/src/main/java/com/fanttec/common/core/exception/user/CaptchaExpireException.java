package com.fanttec.common.core.exception.user;

import java.io.Serial;

/**
 * 验证码失效异常类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时29分08秒
 **/
public class CaptchaExpireException extends UserException {
    @Serial
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException() {
        super("user.jcaptcha.expire", null);
    }
}
