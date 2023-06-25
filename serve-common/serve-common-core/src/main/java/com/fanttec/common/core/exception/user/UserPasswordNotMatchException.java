package com.fanttec.common.core.exception.user;

import java.io.Serial;

/**
 * 用户密码不正确或不符合规范异常类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时29分08秒
 **/
public class UserPasswordNotMatchException extends UserException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
