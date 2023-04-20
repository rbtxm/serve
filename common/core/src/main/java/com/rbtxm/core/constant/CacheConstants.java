package com.rbtxm.core.constant;

/**
 * 缓存常量信息
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月11日  19时20分23秒
 **/
public class CacheConstants {
    /**
     * 缓存有效期，默认720（分钟）
     */
    public final static long EXPIRATION = 720;

    /**
     * 缓存刷新时间，默认120（分钟）
     */
    public final static long REFRESH_TIME = 120;

    /**
     * token缓存前缀
     */
    public final static String LOGIN_TOKEN_KEY = "login_tokens:";
}
