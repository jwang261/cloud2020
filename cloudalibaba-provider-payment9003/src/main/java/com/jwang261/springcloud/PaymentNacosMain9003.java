package com.jwang261.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jwang261
 * @date 2020/8/5 1:52 AM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosMain9003.class, args);
    }
}
