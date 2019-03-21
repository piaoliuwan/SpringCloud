package mybatis.service;


import com.springcloud.mybatis.pojo.Dept;
import mybatis.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> queryAll(){
       return deptMapper.selectAll();
    }
}
