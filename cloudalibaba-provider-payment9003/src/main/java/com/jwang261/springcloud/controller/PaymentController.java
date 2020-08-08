package com.jwang261.springcloud.controller;

import com.jwang261.springcloud.pojo.CommonResult;
import com.jwang261.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author jwang261
 * @date 2020/8/5 3:44 AM
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static{
        hashMap.put(1L, new Payment(1L,"0001"));
        hashMap.put(2L, new Payment(2L,"0002"));
        hashMap.put(3L, new Payment(3L,"0003"));

    }
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql, serverPort: " + serverPort, payment);
        return result;
    }


}
