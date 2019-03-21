package com.springcloud.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages="com.springcloud.mybatis.mapper")//@MapperScan中配置我们需要扫描的Mapper位置
public class springcloud_provider_app {
    public static void main(String[] args){
        SpringApplication.run(springcloud_provider_app.class,args);
    }
}
