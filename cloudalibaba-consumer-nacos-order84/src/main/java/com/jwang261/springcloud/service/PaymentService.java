package com.jwang261.springcloud.service;

import com.jwang261.springcloud.pojo.CommonResult;
import com.jwang261.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jwang261
 * @date 2020/8/5 4:32 AM
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    //Feign的远程调用用我的服务接口去掉远方的Controller
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}
