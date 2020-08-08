package com.jwang261.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author jwang261
 * @date 2020/7/28 7:43 PM
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "ThreadPool： " + Thread.currentThread().getName()
                + " paymentInfo_OK, id: " + id
                + "\t" + "End";
    }

    //Fallback
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){

        int timeNumber = 1;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "ThreadPool： " + Thread.currentThread().getName()
                + " paymentInfo_TimeOut, id " + id
                + "\t" + "Time: " + timeNumber + " seconds";

    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "ThreadPool： " + Thread.currentThread().getName()
                + " paymentInfo_TimeoutHandler, id = " + id
                + "\t" + "fallBackMethod";
    }

    //Break
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数峰值
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//多大失败概率跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("id cannot be negative");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "/t"
                + "success, serialNumber = " + serialNumber;

    }
    public String paymentCircuitBreaker_Fallback(Integer id){
        return "id cannot be negative: id = " + id;
    }

}


