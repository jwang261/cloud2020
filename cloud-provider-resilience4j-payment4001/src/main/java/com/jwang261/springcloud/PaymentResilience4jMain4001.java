package com.jwang261.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jwang261
 * @date 2020/8/2 6:23 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentResilience4jMain4001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentResilience4jMain4001.class, args);
    }
}
