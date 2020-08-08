package com.jwang261.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author jwang261
 * @date 2020/8/3 1:30 AM
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        log.info("test D");
        return "======This is test A======";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info("test D");
        return "======This is test B======";
    }

    //RT
    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test D");
        return "======This is test D for RT======";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "fallback_testHotKey")
    //value名称唯一就行，这里为了规范和url一样,到时候dashboard配置的时候需要用到
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2,
                             @RequestParam(value = "p3", required = false) String p3){
        return "Test hot key succeed";
    }

    public String fallback_testHotKey(String p1, String p2, String p3, BlockException exception){
        return "This is fallback method for testHotKey";
    }
}
