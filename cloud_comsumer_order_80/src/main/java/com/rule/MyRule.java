package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: springcloud
 * @Package: com.rule
 * @ClassName: MyRule
 * @Author: chenwei
 * @Description: 自定义规则类
 * @Date: 2020/9/21
 * @Version: 1.0
 */
@Configuration
public class MyRule {
    @Bean
    public IRule myselfRule() {
        return new RandomRule();
    }
}
