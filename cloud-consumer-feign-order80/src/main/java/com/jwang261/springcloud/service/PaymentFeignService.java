package com.jwang261.springcloud.service;

import com.jwang261.springcloud.pojo.CommonResult;
import com.jwang261.springcloud.pojo.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author jwang261
 * @date 2020/7/27 10:48 PM
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(Payment payment);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
