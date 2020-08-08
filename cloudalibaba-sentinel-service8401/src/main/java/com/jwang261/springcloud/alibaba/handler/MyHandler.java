package com.jwang261.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jwang261.springcloud.pojo.CommonResult;
import com.jwang261.springcloud.pojo.Payment;

/**
 * @author jwang261
 * @date 2020/8/3 5:31 PM
 */

public class MyHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444, "Global Fallback Method---1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "Global Fallback Method---2");
    }
}
