package com.fanttec.common.core.utils.poi;

/**
 * Excel数据格式处理适配器
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月20日 星期二 15时43分01秒
 **/
public interface ExcelHandlerAdapter {
    /**
     * 格式化
     *
     * @param value 单元格数据值
     * @param args  excel注解args参数组
     * @return 处理后的值
     */
    Object format(Object value, String[] args);
}
