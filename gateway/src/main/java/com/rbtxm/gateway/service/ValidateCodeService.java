package com.rbtxm.gateway.service;

import java.io.IOException;

/**
 * 验证码处理
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月20日 周四 23时55分54秒
 **/
public interface ValidateCodeService
{
    /**
     * 生成验证码
     */
    public AjaxResult createCaptcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCaptcha(String key, String value) throws CaptchaException;
}
