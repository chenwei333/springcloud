package com.wei.service;


import com.wei.entities.Payment;
import com.wei.result.SimpleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //配置feign参数调用
public interface PaymentFeignService {


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("payment/get/{id}")
    SimpleResponse<Payment> selectOne(@PathVariable("id") Long id);
/*
    @GetMapping("payment/feign/timeout")
    String getFeignTimeOut();*/
}
