package com.controller;

import com.springcloud.Hystrix.service.DeptFrignHystrixClientService;
import com.springcloud.mybatis.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomController {

    private static final String REST_URL_PREFIX1 = "http://localhost:8001/springcloud-provider";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT/springcloud-provider";
   /* @Autowired
    private DeptFrignClientService deptFrignClientService;*/
    /**
     * 兼容hystrix服务降级
     */
    @Autowired
    private DeptFrignHystrixClientService deptFrignHystrixClientService;

    @GetMapping(value = "/customfeign/queryAll")
    public List<Dept> getAll(){
        //return deptFrignClientService.queryAll();
        return deptFrignHystrixClientService.queryAll();
    }


}
