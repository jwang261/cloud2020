package com.jwang261.springcloud.alibaba.dao;

import com.jwang261.springcloud.alibaba.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jwang261
 * @date 2020/8/6 1:12 AM
 */
@Mapper
public interface OrderDao {

    void create(Order order);

    //change status 0 -> 1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
