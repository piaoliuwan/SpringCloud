package com.springcloud.feign.service;

import com.springcloud.mybatis.pojo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptFrignClientService {
    //此路径类似于跟@FeignClient路径进行拼接之后访问的真正地址（如果rureka注册名为SPRINGCLOUD-PROVIDER-DEPT的项目有访问路径；请再此进行拼接）
    @RequestMapping(value = "springcloud-provider/queryAll")

    public List<Dept> queryAll();
}
