package com.rbtxm.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月11日  19时33分20秒
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum HttpStatusEnum {

    SUCCESS(200, "操作成功"),

    FAIL(500, "操作失败"),

    UNAUTHORIZED(401, "未授权"),

    FORBIDDEN(403, "授权过期"),

    VALIDATE_FAILED(404, "资源服务未找到"),

    METHOD_NOT_ALLOWED(405, "不允许的http方法"),

    BAD_REQUEST(400, "参数列表错误（缺少，格式不匹配）");

    private Integer code;

    private String dec;

}
