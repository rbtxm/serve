package com.fanttec.common.core.exception.file;

import java.io.Serial;

/**
 * 文件名称超长限制异常类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
public class FileNameLengthLimitExceededException extends FileException {
    @Serial
    private static final long serialVersionUID = 1L;

    public FileNameLengthLimitExceededException(int defaultFileNameLength) {
        super("upload.filename.exceed.length", new Object[] { defaultFileNameLength });
    }
}
