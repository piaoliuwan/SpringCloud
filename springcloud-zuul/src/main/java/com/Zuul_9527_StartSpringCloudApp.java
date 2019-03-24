package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
/**
 * 开启路由
 */
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp
{
	 public static void main(String[] args)
	{
		SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
	}
}
/**
 * 不开启注解访问路径：http://localhost:8001/springcloud-provider/queryAll
 * 开启注解：
 * http://注解的地址：端口号/想要访问的服务的eureka名称（必须小写）/想要访问的服务的名称/rest正常路径
 * 开启注解：http://myzuul.com:9527/springcloud-provider-dept/springcloud-provider/queryAll
 */
