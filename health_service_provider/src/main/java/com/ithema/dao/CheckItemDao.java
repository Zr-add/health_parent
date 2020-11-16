package com.ithema.dao;

import com.github.pagehelper.Page;
import com.ithema.entity.PageResult;
import com.ithema.entity.QueryPageBean;
import com.ithema.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    public void add(CheckItem checkItem);
    public Page<CheckItem> selectByCondition(String qureyString);
    public long findCountByCheckItemId(Integer id);
    public void deleteById(Integer id);
    public CheckItem findById(Integer id);
    public void edit(CheckItem checkItem);
    public List<CheckItem> findAll();
}
