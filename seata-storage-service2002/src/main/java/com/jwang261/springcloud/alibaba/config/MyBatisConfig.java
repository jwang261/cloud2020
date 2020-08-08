package com.jwang261.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.jwang261.springcloud.alibaba.dao"})
public class MyBatisConfig {

}
