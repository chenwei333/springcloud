package com.wei.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //无参数的构造器
public class SimpleResponse <T> {
    private Integer code;
    private String message;
    private  T t;

    public SimpleResponse(T t,String message) {
        this.code =200;
        this.message =message;
        this.t = t;
    }
}
