package com.rbtxm.datasource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * @Author: guanxiangkai
 * @Description:
 * @Data: 2023年03月29日 周三 16时33分23秒
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
        // 子连接配置

    }
}
