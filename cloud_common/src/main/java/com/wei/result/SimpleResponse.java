package com.wei.result;

import lombok.Data;

@Data
public class SimpleResponse <T> extends CommonResponse{
    private  T t;

    public SimpleResponse(T t,String message) {
        super(message);
        this.t = t;
    }
}
