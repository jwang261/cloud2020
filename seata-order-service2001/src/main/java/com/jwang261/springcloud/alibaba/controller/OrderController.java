package com.jwang261.springcloud.alibaba.controller;

import com.jwang261.springcloud.alibaba.entity.CommonResult;
import com.jwang261.springcloud.alibaba.entity.Order;
import com.jwang261.springcloud.alibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jwang261
 * @date 2020/8/6 3:58 AM
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"successfully create order");
    }

}
