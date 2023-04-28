package com.rbtxm.datasource;

import com.rbtxm.datasource.holder.DynamicDataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月28日  16时01分42秒
 **/
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSource();
    }
}