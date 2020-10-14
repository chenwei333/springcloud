package com.wei.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wei.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

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

    // #_________________________________________________________________________
    @HystrixCommand(fallbackMethod = "doTimeOut_fallbackHandler",commandProperties = {
            // 熔断器在整个统计时间内是否开启的阀值
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 至少有3个请求才进行熔断错误比率计算
            /**
             * 设置在一个滚动窗口中，打开断路器的最少请求数。
             比如：如果值是20，在一个窗口内（比如10秒），收到19个请求，即使这19个请求都失败了，断路器也不会打开。
             */
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
            //当出错率超过50%后熔断器启动
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            // 熔断器工作时间，超过这个时间，先放一个请求进去，成功的话就关闭熔断，失败就再等一段时间
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            // 统计滚动的时间窗口
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("----id 不能为负");
        }
       return "数据调用成功" + UUID.randomUUID().toString();
    }
















}
