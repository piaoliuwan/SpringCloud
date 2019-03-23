package com.springcloud.Hystrix.service;

import com.springcloud.mybatis.pojo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//feign负载均衡兼容hystrix服务降级
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientHystrixServiceFallBackFactory.class)
public interface DeptFrignHystrixClientService {
    //此路径类似于跟@FeignClient路径进行拼接之后访问的真正地址（如果rureka注册名为SPRINGCLOUD-PROVIDER-DEPT的项目有访问路径；请再此进行拼接）
    @RequestMapping(value = "springcloud-provider/queryAll")
    public List<Dept> queryAll();
}
