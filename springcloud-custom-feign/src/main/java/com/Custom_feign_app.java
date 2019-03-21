package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/*
Cannot determine embedded database driver class for database type NONE
检查下有没有配置数据库相关的信息， 因为spring boot只要你在pom中引入了mybatis-spring-boot-starter 他就会默认需要加载数据库相关的配置

        你要是没有在配置文件中配置数据相关信息，它会加载默认的配置（不存在的） 然后就报错了， 所以你要是要用数据库相关的东西 你就完善配置
        不用数据库相关的东西 就不要在pom中引入相关依赖*/
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})//阻止spring boot自动注入dataSource bean
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com"})
@ComponentScan("com")
//@RibbonClient(name ="SPRINGCLOUD-PROVIDER-DEPT",configuration = MyselfRule.class)
public class Custom_feign_app {
    public static void main(String [] args){
        SpringApplication.run(Custom_feign_app.class,args);
    }
}
