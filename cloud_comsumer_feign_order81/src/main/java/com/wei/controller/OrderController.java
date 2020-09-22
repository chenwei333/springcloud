package com.wei.controller;

import com.wei.entities.Payment;
import com.wei.result.SimpleResponse;
import com.wei.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("comsumer")
public class OrderController {

    //根据注册数据进行调用

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("payment/selectOne/{id}")
    public SimpleResponse<Payment> getPayment(@PathVariable("id") long id) {
        return paymentFeignService.selectOne(id);
    }



}
