package com.rbtxm.api.file.service.factory;

import com.rbtxm.api.file.service.RemoteFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 文件模块RPC调用工厂
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月20日  11时09分42秒
 **/
@Slf4j
@Component
public class RemoteFileFallbackFactory implements FallbackFactory<RemoteFileService> {
    @Override
    public RemoteFileService create(Throwable throwable) {
        log.error("文件模块RPC服务调用失败:{}", throwable.getMessage());
        return new RemoteFileService(){

        };
    }
}
