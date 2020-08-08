package com.jwang261.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author jwang261
 * @date 2020/7/29 3:49 PM
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "======PaymentFallbackService paymentInfo_OK======";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "======PaymentFallbackService paymentInfo_Timeout======";
    }
}
