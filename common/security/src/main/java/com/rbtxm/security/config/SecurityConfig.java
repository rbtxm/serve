package com.rbtxm.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @Author: guanxiangkai
 * @Description:
 * @Data: 2023年04月04日 周二 18时01分46秒
 **/
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange()
                .pathMatchers("/public/**").permitAll()
                .anyExchange().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
}
