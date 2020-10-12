package com.wei.service;

public interface PaymentService {

    void doSuccess(Integer id);

    void doError(Integer id);

    void doTimeOut(Integer id);



}
