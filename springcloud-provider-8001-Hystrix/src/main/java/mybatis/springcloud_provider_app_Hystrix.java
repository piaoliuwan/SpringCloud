package mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
//启用服务熔断
@EnableCircuitBreaker
@MapperScan(basePackages="mybatis.mapper")//@MapperScan中配置我们需要扫描的Mapper位置
public class springcloud_provider_app_Hystrix {
    public static void main(String[] args){
        SpringApplication.run(springcloud_provider_app_Hystrix.class,args);
    }
}
