package com.fanttec.common.core.enums;

import lombok.Getter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 字符编码枚举
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时29分08秒
 **/
@Getter
public enum EncodingEnums {

    UTF_8(StandardCharsets.UTF_8),
    UTF_16(StandardCharsets.UTF_16),
    ISO_8859_1(StandardCharsets.ISO_8859_1),
    GBK(Charset.forName("GBK")),
    GB2312(Charset.forName("GB2312")),
    BIG5(Charset.forName("Big5"));

    private final Charset charset;

    EncodingEnums(Charset charset) {
        this.charset = charset;
    }
}
