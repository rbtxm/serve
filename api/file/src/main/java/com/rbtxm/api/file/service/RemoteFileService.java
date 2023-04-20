package com.rbtxm.api.file.service;

import com.rbtxm.api.file.service.factory.RemoteFileFallbackFactory;
import com.rbtxm.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 文件模块RPC调用服务
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月20日  11时08分06秒
 **/
@FeignClient(contextId = "remoteFileService", value = ServiceNameConstants.FILE_SERVICE, fallbackFactory =RemoteFileFallbackFactory.class )
public interface RemoteFileService {
}
