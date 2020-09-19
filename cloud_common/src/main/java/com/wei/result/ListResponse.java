package com.wei.result;

import lombok.Data;

import java.util.List;

@Data
public class ListResponse <T> extends CommonResponse{
    private  List<T> t;

    public ListResponse(List<T> t, String message) {
        super(message);
        this.t = t;
    }
}
