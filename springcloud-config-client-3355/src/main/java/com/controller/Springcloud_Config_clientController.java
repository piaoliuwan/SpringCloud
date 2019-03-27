package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Springcloud_Config_clientController {
    @Value("${spring.application.name}")
    private String applicationName;


    private String serverpath;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String configMsg(){
        System.out.println("http://localhost:"+port+"/"+serverpath+"----eurekaServers"+eurekaServers+"-----applicationName"+applicationName);
        return "http://localhost:"+port+"/serverpath"+"----eurekaServers"+eurekaServers+"-----applicationName"+applicationName;
    }
}

/**
 * SpringBoot默认支持properties(.properties)和YAML(.yml  .yaml )两种格式的配置文件

 1.加载顺序

 若application.yml 和bootStrap.yml 在同一目录下 :bootstrap.yml先加载  application.yml后加载

 bootstrap.yml 用于应用程序上下文的引导阶段。bootstrap.yml 由父Spring ApplicationContext加载。

 父ApplicationContext 被加载到使用 application.yml 的之前。

 2.配置区别
 bootstrap.yml 和application.yml 都可以用来配置参数。

 bootstrap.yml 用来程序引导时执行，应用于更加早期配置信息读取. 可以理解成系统级别的一些参数配置，这些参数一般是不会变动的。一旦bootStrap.yml 被加载，则内容不会被覆盖


 application.yml 可以用来定义应用级别的， 应用程序特有配置信息，可以用来配置后续各个模块中需使用的公共参数等.如果加载的application.yml的内容标签与bootstrap的标签一致，application 也不会覆盖bootstrap, 而application.yml 里面的内容可以动态替换。

 3. 典型的应用场景如下：

 当使用 Spring Cloud Config Server 的时候，你应该在 bootstrap.yml 里面指定 spring.application.name 和 spring.cloud.config.server.git.uri
 和一些加密/解密的信息
 *
 *
 * */