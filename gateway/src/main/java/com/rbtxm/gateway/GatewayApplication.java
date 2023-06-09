package com.rbtxm.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 网关路由启动器
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年06月07日 星期三 14时29分18秒
 **/
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println("网关路由启动成功");
    }
}
