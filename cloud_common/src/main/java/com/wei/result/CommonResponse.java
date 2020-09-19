package com.wei.result;

import lombok.Data;

@Data
public class CommonResponse {

    private Integer code;
    private String message;

    public CommonResponse( String message) {
        this.code =  200;
        this.message =  message;
    }

    public CommonResponse(Integer code, String message) {
        this.code =  code;
        this.message =  message;
    }
}
