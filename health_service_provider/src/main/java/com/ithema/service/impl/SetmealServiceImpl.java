package com.ithema.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ithema.dao.SetmealDao;
import com.ithema.entity.PageResult;
import com.ithema.entity.QueryPageBean;
import com.ithema.pojo.CheckItem;
import com.ithema.pojo.Setmeal;
import com.ithema.service.SetmealService;
import org.apache.zookeeper.Op;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealDao setmealDao;

    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setmealDao.add(setmeal);
        Integer id = setmeal.getId();
        for (Integer checkgroupId : checkgroupIds) {
            Map<String, Integer> stringIntegerHashMap = new HashMap<>();
            stringIntegerHashMap.put("checkgroupId",checkgroupId);
            stringIntegerHashMap.put("setmealId",id);
            setmealDao.setSetmealAndCheckGroup(stringIntegerHashMap);
        }
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage, pageSize);
        Page<Setmeal> setmeals = setmealDao.findByCondition(queryString);
        long total = setmeals.getTotal();
        List<Setmeal> result = setmeals.getResult();
        PageResult pageResult = new PageResult(total,result);
        return pageResult;
    }
}
