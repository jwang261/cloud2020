package com.jwang261.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;


/**
 * @author jwang261
 * @date 2020/7/24 10:46 PM
 */
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk(){
        return "springcloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();

    }


}
