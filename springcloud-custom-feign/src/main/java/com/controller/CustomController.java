package com.controller;

import com.springcloud.feign.service.DeptFrignClientService;
import com.springcloud.mybatis.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CustomController {

    private static final String REST_URL_PREFIX1 = "http://localhost:8001/springcloud-provider";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT/springcloud-provider";
    @Autowired
    private DeptFrignClientService deptFrignClientService;

    @GetMapping(value = "/customfeign/queryAll")
    public List<Dept> getAll(){
        return deptFrignClientService.queryAll();
    }


}
