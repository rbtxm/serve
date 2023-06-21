package com.fanttec.common.core.constant;

/**
 * 缓存常量信息
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时03分51秒
 **/
public class CacheConstants {

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码有效时间（分钟）
     */
    public static final long CAPTCHA_EXPIRATION = 5;

    /**
     * 账户密码错误记录缓存 key
     */
    public static final String ACCOUNT_PASSWORD_ERROR_COUNT_KEY = "account_password_error_count:";

    /**
     * 账户密码错误记录缓存有效时间（分钟）
     */
    public static final long ACCOUNT_PASSWORD_ERROR_COUNT_EXPIRATION = 10;

    /**
     * token缓存 key
     */
    public static final String TOKEN_KEY = "tokens:";

    /**
     * token有效时间（分钟）
     */
    public static final long TOKEN_EXPIRATION = 60*24*7;

    /**
     * 字典缓存 key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";
}
