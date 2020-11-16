package com.ithema.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ithema.entity.PageResult;
import com.ithema.entity.QueryPageBean;
import com.ithema.entity.Result;
import com.ithema.pojo.CheckItem;

import java.util.List;

@Service
public interface CheckItemService {
    public void add(CheckItem checkItem);
    public PageResult QueryPage(QueryPageBean queryPageBean);
    public void deleteById(Integer id);
    public CheckItem findById(Integer id);
    public void edit(CheckItem checkItem);
    public List<CheckItem> findAll();
}
