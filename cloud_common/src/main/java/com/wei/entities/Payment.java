package com.wei.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Payment implements Serializable {

    private static final long serialVersionUID = 3022456707865174389L;
    private Long id;
    private String serial;
}
