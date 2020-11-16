package com.ithema.dao;

import com.github.pagehelper.Page;
import com.ithema.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

public interface CheckGroupDao {
    public void add(CheckGroup checkGroup);
    public void setCheckItemAndCheckGroup(Map map);
    public Page<CheckGroup> findByCondition(String queryString);
    public void delete(Integer id);
    public void deleteAssocication(Integer id);
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    public CheckGroup findById(Integer id);
    public void edit(CheckGroup checkGroup);
    public List<CheckGroup> findAll();
}
