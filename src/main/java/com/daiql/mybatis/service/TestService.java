package com.daiql.mybatis.service;

import com.daiql.mybatis.annotation.ExtPageHelper;
import com.daiql.mybatis.bean.RegisterList;
import com.daiql.mybatis.mapper.RegisterListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: daiql
 * @CreateDate: 2019/4/17 8:41 AM
 * @Version: 1.0
 */
@Service
public class TestService {

    @Autowired
    private RegisterListMapper registerListMapper;

    @ExtPageHelper
    public Object queryAll(int page, int size) {
        List<RegisterList> list = registerListMapper.queryAll();
        return list;
    }
}
