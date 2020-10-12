package com.wei.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wei.result.CommonResponse;
import com.wei.service.PaymentFeignHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comsumer")
public class OrderController {

    //根据注册数据进行调用

    @Autowired
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping("doSuccess/{id}")
    public CommonResponse doSuccess(@PathVariable("id") Integer id) {
        paymentFeignHystrixService.doSuccess(id);
        return new CommonResponse(" 执行成功 " );
    }

    @GetMapping("doError/{id}")
    public CommonResponse doError(@PathVariable("id") Integer id) {
        paymentFeignHystrixService.doError(id);
        return new CommonResponse("执行失败 "  );
    }
    @GetMapping("doTimeOut/{id}")
    @HystrixCommand(fallbackMethod = "doTimeOut_fallbackHandler",
            commandProperties = {
                    //设置超时处理时间,5秒钟时间类正常
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            })
    public CommonResponse doTimeOut(@PathVariable("id") Integer id) {
        paymentFeignHystrixService.doTimeOut(id);
        return new CommonResponse("执行时间 "  );
    }

    public void doTimeOut_fallbackHandler(Integer id){
        System.out.println("我是消费者83，对面服务繁忙，或者我出错" );
    }
}
