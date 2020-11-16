package com.ithema.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ithema.entity.PageResult;
import com.ithema.entity.QueryPageBean;
import com.ithema.entity.Result;
import com.ithema.pojo.Setmeal;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface SetmealService {
    public void add(Setmeal setmeal, Integer[] checkgroupIds);
    public PageResult findPage(QueryPageBean queryPageBean);
}
