package com.rbtxm.api.system.service.factory;

import com.rbtxm.api.system.service.RemoteSystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 系统模块RPC调用工厂
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月20日  11时09分42秒
 **/
@Slf4j
@Component
public class RemoteSysTemFallbackFactory implements FallbackFactory<RemoteSystemService> {
    @Override
    public RemoteSystemService create(Throwable throwable) {
        log.error("系统模块RPC服务调用失败:{}", throwable.getMessage());
        return new RemoteSystemService(){

        };
    }
}
