package com.rbtxm.datasource.holder;

/**
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月28日  15时59分56秒
 **/
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDataSource(String dataSource) {
        CONTEXT_HOLDER.set(dataSource);
    }

    public static String getDataSource() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSource() {
        CONTEXT_HOLDER.remove();
    }
}
