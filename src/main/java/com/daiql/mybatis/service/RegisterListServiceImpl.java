package com.daiql.mybatis.service;

import com.daiql.mybatis.bean.RegisterList;
import com.daiql.mybatis.mapper.RegisterListMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: daiql
 * @CreateDate: 2019/4/17 8:31 AM
 * @Version: 1.0
 */
@Service
public class RegisterListServiceImpl implements RegisterListService {

    @Autowired
    private RegisterListMapper registerListMapper;


    @Override
    public int insert(RegisterList registerList) {
        return registerListMapper.insert(registerList);
    }

    @Override
    public int deleteById(int id) {
        return registerListMapper.deleteById(id);
    }

    @Override
    public int update(RegisterList registerList) {
        return registerListMapper.update(registerList);
    }

    @Override
    public RegisterList queryOne(int id) {
        return registerListMapper.queryOne(id);
    }

    @Override
    public List<RegisterList> queryAll() {
        return registerListMapper.queryAll();
    }

    @Override
    public PageInfo<RegisterList> queryAll(int page, int size) {
        PageHelper.startPage(page, size);
        List<RegisterList> list = registerListMapper.queryAll();
        PageInfo<RegisterList> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
