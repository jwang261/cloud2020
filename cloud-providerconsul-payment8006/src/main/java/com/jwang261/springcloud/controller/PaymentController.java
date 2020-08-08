package com.jwang261.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author jwang261
 * @date 2020/7/27 4:07 AM
 */
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul (){
        return "springcloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();

    }


}
