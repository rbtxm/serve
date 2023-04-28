package com.rbtxm.datasource.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月28日  16时03分02秒
 **/
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {

    private LinkedHashMap<String, DataSourceProperty> dataSources;

    // 父连接配置

    @Data
    public static class DataSourceProperty {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
        // 子连接配置
    }
}