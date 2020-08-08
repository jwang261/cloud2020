package com.jwang261.springcloud.service;

import com.jwang261.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
