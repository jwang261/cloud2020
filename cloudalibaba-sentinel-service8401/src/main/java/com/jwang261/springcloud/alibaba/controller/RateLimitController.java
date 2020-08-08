package com.jwang261.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jwang261.springcloud.alibaba.handler.MyHandler;
import com.jwang261.springcloud.pojo.CommonResult;
import com.jwang261.springcloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jwang261
 * @date 2020/8/3 5:03 PM
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "ByResource Succeed", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t Service not available");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200, "ByUrl Succeed", new Payment(2020L, "serial002"));
    }

    //customizedBlockHandler
    @GetMapping("/customizedBlockHandler")
    @SentinelResource(value = "customizedBlockHandler",
            blockHandlerClass = MyHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customizedBlockHandler(){
        return new CommonResult(200, "ByCustomizedBlockHandler Succeed", new Payment(2020L, "serial003"));

    }

}
