package com.rbtxm.api.system.service;

import com.rbtxm.api.system.service.factory.RemoteSysTemFallbackFactory;
import com.rbtxm.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 系统模块RPC调用服务
 *
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月20日  11时08分06秒
 **/
@FeignClient(contextId = "remoteFileService", value = ServiceNameConstants.FILE_SERVICE, fallbackFactory = RemoteSysTemFallbackFactory.class )
public interface RemoteSystemService {
}
