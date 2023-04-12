package com.rbtxm.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * 限流规则配置
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月13日 周四 00时28分03秒
 **/
@Configuration
public class KeyResolverConfiguration {
    @Bean
    public KeyResolver pathKeyResolver() {
        // 根据请求路径限流
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }
}
