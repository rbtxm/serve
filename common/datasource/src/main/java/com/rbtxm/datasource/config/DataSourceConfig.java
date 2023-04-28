package com.rbtxm.datasource.config;

import com.rbtxm.datasource.DynamicRoutingDataSource;
import com.rbtxm.datasource.config.properties.DataSourceProperties;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月28日  16时00分28秒
 **/
@Configuration
public class DataSourceConfig {
    @Resource
    private DataSourceProperties dataSourceProperties;

    @Bean
    @Primary
    public DataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>(dataSourceProperties.getDataSources().size());
        dataSourceProperties.getDataSources().forEach((k, v) -> {
            DataSourceBuilder.create()
                    .url(v.getUrl())
                    .username(v.getUsername())
                    .password(v.getPassword())
                    .driverClassName(v.getDriverClassName())
                    .build();
        });
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(targetDataSources.values().iterator().next());
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.example.demo.entity")
                .persistenceUnit("dynamic")
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
