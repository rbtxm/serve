package com.rbtxm.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @Description:
 * @Author: guanxiangkai
 * @CreatedTime: 2023-03-15 00:16:00:16
 * @Version: 1.0.0
 */
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println("网关路由启动成功");
    }
}


