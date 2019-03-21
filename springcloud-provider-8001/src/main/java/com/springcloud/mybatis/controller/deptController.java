package com.springcloud.mybatis.controller;

import com.springcloud.mybatis.pojo.Dept;
import com.springcloud.mybatis.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class deptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "queryAll")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @GetMapping(value = "test")
    public String test(){
        System.out.println("123456");
        return "12345";
    }

    @RequestMapping(value = "provider/dictionary")
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        List<ServiceInstance> srvList = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }
}
