package com.jwang261.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author jwang261
 * @date 2020/8/6 6:50 AM
 */
@Mapper
public interface AccountDao {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
