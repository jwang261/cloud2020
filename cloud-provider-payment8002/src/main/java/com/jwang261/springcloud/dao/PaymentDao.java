package com.jwang261.springcloud.dao;

import com.jwang261.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jwang261
 * @date 2020/7/24 10:09 PM
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
