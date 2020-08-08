package com.jwang261.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author jwang261
 * @date 2020/7/28 6:55 PM
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7000 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7000.class, args);

    }
}
