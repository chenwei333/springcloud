package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient //eureka 时使用
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
public class PaymentHystrixMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8004.class,args);
    }
}
