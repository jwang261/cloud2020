package com.jwang261.springcloud.service;

import com.jwang261.springcloud.pojo.CommonResult;
import com.jwang261.springcloud.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 * @author jwang261
 * @date 2020/8/5 4:34 AM
 */
@Component
public class PaymentFallbackService implements PaymentService {


    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "Fallback Method by PaymentFallbackService",
                new Payment(id,"invalid id"));
    }
}
