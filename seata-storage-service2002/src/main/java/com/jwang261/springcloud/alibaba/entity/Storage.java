package com.jwang261.springcloud.alibaba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jwang261
 * @date 2020/8/6 6:28 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;

}
