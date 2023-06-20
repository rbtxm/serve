package com.fanttec.common.core.exception.file;

import java.io.Serial;

/**
 * 文件名大小限制异常类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
public class FileSizeLimitExceededException extends FileException {
    @Serial
    private static final long serialVersionUID = 1L;

    public FileSizeLimitExceededException(long defaultMaxSize) {
        super("upload.exceed.maxSize", new Object[] { defaultMaxSize });
    }
}
