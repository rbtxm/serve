package com.rbtxm.security.config.constant;

/**
 * 登陆常量
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月13日 周四 23时15分46秒
 **/
public class LoginConstants {
    /**
     * 密码最大错误次数
     */
    public final static int PASSWORD_MAX_RETRY_COUNT = 5;

    /**
     * 密码锁定时间，默认10（分钟）
     */
    public final static long PASSWORD_LOCK_TIME = 10;

    /**
     * 登录账户密码错误次数 redis key
     */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";
}
