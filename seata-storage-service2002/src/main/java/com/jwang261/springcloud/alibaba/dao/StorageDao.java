package com.jwang261.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jwang261
 * @date 2020/8/6 6:43 AM
 */
@Mapper
public interface StorageDao {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
