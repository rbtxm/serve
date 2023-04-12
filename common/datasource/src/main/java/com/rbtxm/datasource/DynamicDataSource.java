package com.rbtxm.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

@Component
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceHolder = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceHolder.get();
    }

    public static void setDataSource(String dataSource) {
        dataSourceHolder.set(dataSource);
    }

    public static void clearDataSource() {
        dataSourceHolder.remove();
    }
}

