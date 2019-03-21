package com.bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//springmvc 中的applicationCOntext.xml
public class CfgBean {

    @Bean//创建一个bean对象
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    //如果不重写就按照默认的轮询进行负载均衡，如果重写则按照新的规则进行负载均衡的实现
    @Bean
    public IRule myRule(){
        //return new RoundRobinRule();默认轮询
        //return new RandomRule();//随机

        return new RetryRule();
    }
}

