package com.springcloud.Hystrix.service;

import com.springcloud.mybatis.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DeptClientHystrixServiceFallBackFactory implements FallbackFactory<DeptFrignHystrixClientService> {

    @Override
    public DeptFrignHystrixClientService create(Throwable cause) {
        return new DeptFrignHystrixClientService() {
            @Override
            public List<Dept> queryAll() {
                List<Dept> deptList = new ArrayList<>();
                Dept dept = new Dept();
                dept.setDname("Consumer客户端提供的降级信息,此刻服务Provider已经关闭").setDb_source("数据库暂无信息");
                deptList.add(dept);
                return deptList;
            }
        };
    }
}
