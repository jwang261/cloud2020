package com.jwang261.springcloud.alibaba.service;

import com.jwang261.springcloud.alibaba.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jwang261
 * @date 2020/8/6 1:34 AM
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Integer count);


}
