package com.ithema.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ithema.dao.CheckItemDao;
import com.ithema.entity.PageResult;
import com.ithema.entity.QueryPageBean;
import com.ithema.entity.Result;
import com.ithema.pojo.CheckItem;
import com.ithema.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    @Override
    public PageResult QueryPage(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage, pageSize);
        Page<CheckItem> checkItems = checkItemDao.selectByCondition(queryString);
        long total = checkItems.getTotal();
        List<CheckItem> result = checkItems.getResult();
        PageResult pageResult = new PageResult(total,result);
        return pageResult;
    }

    @Override
    public void deleteById(Integer id) {
        long countByCheckItemId = checkItemDao.findCountByCheckItemId(id);
        if(countByCheckItemId > 0){
            throw new RuntimeException("添加失败");
        }else {
            checkItemDao.deleteById(id);
        }
    }

    @Override
    public CheckItem findById(Integer id) {
        CheckItem byId = checkItemDao.findById(id);
        return byId;
    }

    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    @Override
    public List<CheckItem> findAll() {
        List<CheckItem> checkItems = checkItemDao.findAll();
        return checkItems;
    }
}
