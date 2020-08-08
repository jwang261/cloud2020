package com.jwang261.springcloud.service;

import com.jwang261.springcloud.dao.PaymentDao;
import com.jwang261.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jwang261
 * @date 2020/7/24 10:41 PM
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
