package mybatis.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.mybatis.pojo.Dept;

import mybatis.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class deptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "queryAll")
    /**
     *服务熔断方法；当发生运行时异常时会调用fallbackMethod所引用的服务熔断方法
     * 此方法的返回值以及参数个数，参数类型  必须完全一致
     */
    @HystrixCommand(fallbackMethod = "processHystrix_Exception")
    public List<Dept> queryAll(){
        int x = 1/0;
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

    /**
     * 服务熔断方法；
     *
     * @return
     */
    public   List<Dept> processHystrix_Exception(){
        List<Dept> deptList = new ArrayList<>();
        Dept dept = new Dept();
        dept.setDb_source("unknown database").setDname("exception is occured");
        deptList.add(dept);
        return deptList;

    }
}
