package mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages="mybatis.mapper")//@MapperScan中配置我们需要扫描的Mapper位置
public class Springcloud_provider_app_8002 {
    public static void main(String[] args){
        SpringApplication.run(Springcloud_provider_app_8002.class,args);
    }
}
