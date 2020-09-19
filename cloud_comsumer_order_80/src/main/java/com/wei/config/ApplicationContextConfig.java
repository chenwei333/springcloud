package com.wei.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  //访问集群的时候 需要配置 才能找到调用具体服务（没有负载均衡策略不能进行访问）
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
