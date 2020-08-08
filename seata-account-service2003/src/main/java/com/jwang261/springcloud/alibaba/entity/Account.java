package com.jwang261.springcloud.alibaba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author jwang261
 * @date 2020/8/6 6:28 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}

