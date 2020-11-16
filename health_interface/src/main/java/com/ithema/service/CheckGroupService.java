package com.ithema.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ithema.entity.PageResult;
import com.ithema.entity.QueryPageBean;
import com.ithema.entity.Result;
import com.ithema.pojo.CheckGroup;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public interface CheckGroupService {
    public void add(CheckGroup checkGroup,Integer[] integers);
    public PageResult findPage(QueryPageBean queryPageBean);
    public void delete(Integer id);
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    public CheckGroup findById(Integer id);
    public void edit(CheckGroup checkGroup, Integer[] checkitems);
    public List<CheckGroup> findAll();
}
