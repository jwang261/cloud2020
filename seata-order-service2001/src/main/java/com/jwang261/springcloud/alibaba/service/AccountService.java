package com.jwang261.springcloud.alibaba.service;

import com.jwang261.springcloud.alibaba.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author jwang261
 * @date 2020/8/6 1:33 AM
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money") BigDecimal money);

}
