package com.wei.service;


import com.wei.result.CommonResponse;
import com.wei.service.impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE" ,fallback = PaymentHystrixServiceImpl.class) //配置feign参数调用
public interface PaymentFeignHystrixService {


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("paymentHystrix/doSuccess/{id}")
    CommonResponse doSuccess(@PathVariable("id") Integer id);


    @GetMapping("paymentHystrix/doError/{id}")
    CommonResponse doError(@PathVariable("id") Integer id) ;

    @GetMapping("paymentHystrix/doTimeOut/{id}")
    CommonResponse doTimeOut(@PathVariable("id") Integer id);
}
