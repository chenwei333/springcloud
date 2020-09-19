package com.wei.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //无参数的构造器
public class CommonResponse {

    private Integer code;
    private String message;

    public CommonResponse( String message) {
        this.code =  200;
        this.message =  message;
    }
}
