package com.jwang261.springcloud.controller;

import com.jwang261.springcloud.pojo.CommonResult;
import com.jwang261.springcloud.pojo.Payment;
import com.jwang261.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jwang261
 * @date 2020/7/27 11:20 PM
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService feignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return feignService.getPaymentById(id);
    }

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return feignService.create(payment);
    }
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return feignService.paymentFeignTimeout();
    }

}
