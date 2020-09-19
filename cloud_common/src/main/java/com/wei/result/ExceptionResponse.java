package com.wei.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //无参数的构造器
public class ExceptionResponse {
    private Integer code;
    private String message;
    public ExceptionResponse(String message) {
        this.message = message;
    }
}
