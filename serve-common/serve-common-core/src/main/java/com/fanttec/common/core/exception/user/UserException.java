package com.fanttec.common.core.exception.user;

import com.fanttec.common.core.exception.base.BaseException;

import java.io.Serial;

/**
 * 用户信息异常类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
public class UserException extends BaseException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
