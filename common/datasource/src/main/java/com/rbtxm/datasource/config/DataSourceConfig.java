package com.rbtxm.datasource.config;

import com.rbtxm.datasource.DynamicDataSource;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import java.util.*;


@Slf4j
@Configuration
public class DataSourceConfig {
    @Resource
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        LinkedHashMap<String, DataSourceProperties.DataSourceProperty> dataSources = dataSourceProperties.getDataSources();
        Map<Object, Object> dataSourceMap = new HashMap<>(dataSources.size());
        dataSources.forEach((k, v) -> dataSourceMap.put(k, DataSourceBuilder.create().url(v.getUrl()).username(v.getUsername()).password(v.getPassword()).build()));
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        // 默认选中第一个数据源
        String firstKey = dataSources.keySet().iterator().next();
        dynamicDataSource.setDefaultTargetDataSource(dataSourceMap.get(firstKey));
        return dynamicDataSource;
    }

    @Bean
    public JtaTransactionManager transactionManager() {
        JtaTransactionManager transactionManager = new JtaTransactionManager();
        transactionManager.setTransactionManagerName("java:/TransactionManager");
        return transactionManager;
    }
}
