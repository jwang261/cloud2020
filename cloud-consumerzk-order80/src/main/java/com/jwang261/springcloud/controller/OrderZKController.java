package com.jwang261.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jwang261
 * @date 2020/7/26 12:20 AM
 */
@RestController
@Slf4j
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }

}
