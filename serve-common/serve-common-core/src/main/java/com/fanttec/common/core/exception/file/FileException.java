package com.fanttec.common.core.exception.file;

import com.fanttec.common.core.exception.base.BaseException;

import java.io.Serial;

/**
 * 文件信息异常类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
public class FileException extends BaseException {
    @Serial
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
