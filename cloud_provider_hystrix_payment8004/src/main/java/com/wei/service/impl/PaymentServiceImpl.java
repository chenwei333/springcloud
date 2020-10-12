package com.wei.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wei.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void doSuccess(Integer id) {
        System.out.println("线程池 " + Thread.currentThread().getName() + "--成功---" + id + "执行成功");
    }

    @Override
    public void doError(Integer id) {
        try {
            System.out.println(10/0);
        }catch (Exception e){

        }

        System.out.println("线程池 " + Thread.currentThread().getName() + "--失败---" + id + "执行成功");
    }

    @Override
    @HystrixCommand(fallbackMethod = "doTimeOut_fallbackHandler",
            commandProperties = {
            //设置超时处理时间,5秒钟时间类正常
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
            })
    public void doTimeOut(Integer id) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程池 " + Thread.currentThread().getName() + "--等待6秒---" + id + "执行成功");
    }

    public void doTimeOut_fallbackHandler(Integer id){
        System.out.println("fallback ------"+ id + "8004服务降级" );
    }
}
