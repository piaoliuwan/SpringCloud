package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 服务监控
 * 所监控的服务端需要有
 *  <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
     依赖才能被监控到

 服务监控的地址：是你想监控的服务的地址；http://IP地址:端口号/项目名称/hystrix.stream

                                        http://localhost:8001/springcloud-provider/hystrix.stream
 */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})//阻止spring boot自动注入dataSource bean
@SpringBootApplication
@EnableHystrixDashboard
public class Springcloud_custom_hystrixdashboard_9001 {
    public static void main(String[] args){
        SpringApplication.run(Springcloud_custom_hystrixdashboard_9001.class,args);
    }
}
