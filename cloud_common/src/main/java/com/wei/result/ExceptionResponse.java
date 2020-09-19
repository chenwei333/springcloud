package com.wei.result;


public class ExceptionResponse extends CommonResponse{
    public ExceptionResponse(String message) {
        super(500,message);
    }
}
