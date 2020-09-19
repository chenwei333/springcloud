package com.wei.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor //无参数的构造器
public class ListResponse <T> {
    private Integer code;
    private String message;
    private  List<T> t;

    public ListResponse(List<T> t, String message) {
        this.code =200;
        this.t = t;
        this.message =message;
    }
}
