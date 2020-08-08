package com.jwang261.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author jwang261
 * @date 2020/7/25 4:29 PM
 */
@SpringBootApplication
@EnableEurekaServer //Tell Spring it is Eureka Server
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
