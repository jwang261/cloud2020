package com.jwang261.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.jwang261.springcloud.pojo.CommonResult;
import com.jwang261.springcloud.pojo.Payment;
import com.jwang261.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jwang261
 * @date 2020/8/5 3:55 AM
 */
@RestController
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "fallbackMethod",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgument!");

        }else if(result.getData() == null){
            throw new NullPointerException("no input value!");
        }
        return result;
    }
    public CommonResult<Payment> fallbackMethod(@PathVariable Long id, Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444,"Your input is not valid!" + e.getMessage(), payment);
    }

    @Autowired
    private PaymentService paymentService;
    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
