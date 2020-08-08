package com.jwang261.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jwang261
 * @date 2020/8/6 4:02 AM
 */
@Configuration
@MapperScan({"com.jwang261.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
