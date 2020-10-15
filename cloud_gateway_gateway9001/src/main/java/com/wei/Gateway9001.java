package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: springcloud
 * @Package: com.wei
 * @ClassName: Gateway9001
 * @Author: chenwei
 * @Description: gateway启动
 * @Date: 2020/10/15
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9001 {
    public static void main(String[] args) {
        SpringApplication.run(Gateway9001.class,args);
    }
}
