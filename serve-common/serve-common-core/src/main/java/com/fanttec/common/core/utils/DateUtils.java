package com.fanttec.common.core.utils;

import cn.hutool.core.date.DateUtil;
import com.fanttec.common.core.enums.DateEnums;

import java.util.Date;

/**
 * 时间工具类
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月21日 星期三 16时55分45秒
 **/
public class DateUtils {

    /**
     * 获取当前时间
     */
    public static String getCurrentDate() {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        return getCurrentDate(now,DateEnums.DATE_TIME_FORMAT.getValue());
    }


    /**
     * 获取当天开始时间
     */
    public static String getTodayStartTime() {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取开始时间
        Date beginOfDay = DateUtil.beginOfDay(now
    }
    /**
     * 获取当天结束时间
     */
    public static String getTodayEndTime() {

    }


    /**
     * 自定义格式获取当前时间
     */
    public static String getCurrentDate(Date date,String format) {
        // 格式化当前时间
        return DateUtil.format(date, format);
    }
}
