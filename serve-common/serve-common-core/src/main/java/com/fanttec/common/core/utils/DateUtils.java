package com.fanttec.common.core.utils;

import cn.hutool.core.date.DateTime;
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
        return getCurrentDate(now, DateEnums.DATE_TIME_FORMAT.getValue());
    }


    /**
     * 获取当天开始时间
     */
    public static String getTodayStartTime() {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取开始时间
        Date beginOfDay = DateUtil.beginOfDay(now);
        return getCurrentDate(beginOfDay, DateEnums.DATE_TIME_FORMAT.getValue());
    }

    /**
     * 获取当天结束时间
     */
    public static String getTodayEndTime() {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取结束时间
        Date endOfDay = DateUtil.endOfDay(now);
        return getCurrentDate(endOfDay, DateEnums.DATE_TIME_FORMAT.getValue());
    }
    /**
     * 获取本周开始时间
     */
    public static String getToWeekStartTime() {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取开始时间
        Date beginOfWeek = DateUtil.beginOfWeek(now,false);
        return getCurrentDate(beginOfWeek, DateEnums.DATE_TIME_FORMAT.getValue());
    }

    /**
     * 获取本周结束时间
     */
    public static String getToWeekEndTime() {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取结束时间
        Date beginOfWeek = DateUtil.endOfWeek(now,false);
        return getCurrentDate(beginOfWeek, DateEnums.DATE_TIME_FORMAT.getValue());
    }
    /**
     * 获取当月开始时间
     */
    public static String getToMonthStartTime() {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取开始时间
        Date beginOfWeek = DateUtil.beginOfWeek(now);
        Date beginOfDay = DateUtil.beginOfDay(now);
        return getCurrentDate(beginOfDay, DateEnums.DATE_TIME_FORMAT.getValue());
    }

    /**
     * 获取当月结束时间
     */
    public static String getToMonthEndTime() {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取结束时间
        Date endOfDay = DateUtil.endOfDay(now);
        return getCurrentDate(endOfDay, DateEnums.DATE_TIME_FORMAT.getValue());
    }
    /**
     * 获取当前时间往后推的时间(秒)
     */
    public static String getAfterDateSecond(int after) {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取当前时间往后推的时间(秒)
        Date futureTime = DateUtil.offsetSecond(now, after);
        return getCurrentDate(futureTime, DateEnums.DATE_TIME_FORMAT.getValue());
    }

    /**
     * 获取当前时间往后推的时间(分)
     */
    public static String getAfterDateMinute(int after) {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取当前时间往后推的时间(秒)
        Date futureTime = DateUtil.offsetMinute(now, after);
        return getCurrentDate(futureTime, DateEnums.DATE_TIME_FORMAT.getValue());
    }

    /**
     * 获取当前时间往后推的时间(时)
     */
    public static String getAfterDateHour(int after) {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取当前时间往后推的时间(秒)
        Date futureTime = DateUtil.offsetHour(now, after);
        return getCurrentDate(futureTime, DateEnums.DATE_TIME_FORMAT.getValue());
    }

    /**
     * 获取当前时间往后推的时间(天)
     */
    public static String getAfterDateDay(int after) {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取当前时间往后推的时间(秒)
        Date futureTime = DateUtil.offsetDay(now, after);
        return getCurrentDate(futureTime, DateEnums.DATE_TIME_FORMAT.getValue());
    }

    /**
     * 获取当前时间往后推的时间(周)
     */
    public static String getAfterDateWeek(int after) {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取当前时间往后推的时间(秒)
        Date futureTime = DateUtil.offsetWeek(now, after);
        return getCurrentDate(futureTime, DateEnums.DATE_TIME_FORMAT.getValue());
    }

    /**
     * 获取当前时间往后推的时间(月)
     */
    public static String getAfterDateMonth(int after) {
        // 获取当前时间的日期对象
        Date now = DateUtil.date();
        // 获取当前时间往后推的时间(秒)
        Date futureTime = DateUtil.offsetMonth(now, after);
        return getCurrentDate(futureTime, DateEnums.DATE_TIME_FORMAT.getValue());
    }

    /**
     * 自定义格式获取当前时间
     */
    public static String getCurrentDate(Date date, String format) {
        // 格式化当前时间
        return DateUtil.format(date, format);
    }
}
