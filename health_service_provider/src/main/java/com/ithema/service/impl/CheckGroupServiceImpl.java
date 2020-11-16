package com.ithema.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ithema.dao.CheckGroupDao;
import com.ithema.entity.PageResult;
import com.ithema.entity.QueryPageBean;
import com.ithema.entity.Result;
import com.ithema.pojo.CheckGroup;
import com.ithema.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {

    @Autowired
    private CheckGroupDao checkGroupDao;

    @Override
    public void add(CheckGroup checkGroup,Integer[] integers) {
        checkGroupDao.add(checkGroup);
        Integer id = checkGroup.getId();
        this.setCheckItemAndCheckGroup(id,integers);
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {

        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckGroup> checkGroups = checkGroupDao.findByCondition(queryString);
        List<CheckGroup> result = checkGroups.getResult();
        long total = checkGroups.getTotal();

        return new PageResult(total,checkGroups);
    }


    public void setCheckItemAndCheckGroup(Integer id,Integer[] itegers){
        if(itegers != null && itegers.length > 0){
            for (Integer iteger : itegers) {
                Map<String, Integer> map = new HashMap<>();
                map.put("checkgroupId", id);
                map.put("checkitemId", iteger);
                checkGroupDao.setCheckItemAndCheckGroup(map);
            }
        }
    }
    public void delete(Integer id){
        checkGroupDao.deleteAssocication(id);
        checkGroupDao.delete(id);
    }

    @Override
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id) {
        return checkGroupDao.findCheckItemIdsByCheckGroupId(id);
    }

    @Override
    public CheckGroup findById(Integer id) {
        return checkGroupDao.findById(id);
    }

    @Override
    public void edit(CheckGroup checkGroup, Integer[] checkitems) {
        checkGroupDao.edit(checkGroup);
        Integer id = checkGroup.getId();
        checkGroupDao.deleteAssocication(id);
        this.setCheckItemAndCheckGroup(id,checkitems);
    }

    @Override
    public List<CheckGroup> findAll() {
        return checkGroupDao.findAll();
    }
}
