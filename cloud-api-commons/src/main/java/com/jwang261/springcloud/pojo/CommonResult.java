package com.jwang261.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jwang261
 * @date 2020/7/24 10:05 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //response
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
