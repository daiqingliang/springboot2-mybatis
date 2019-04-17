package com.daiql.mybatis.service;

import com.daiql.mybatis.bean.RegisterList;
import com.daiql.mybatis.mapper.CommonMapper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description:
 * @Author: daiql
 * @CreateDate: 2019/4/17$ 8:31 AM$
 * @Version: 1.0
 */

public interface RegisterListService {

    int insert(RegisterList registerList);

    int deleteById(int id);

    int update(RegisterList registerList);

    RegisterList queryOne(int id);

    List<RegisterList> queryAll();

    PageInfo<RegisterList> queryAll(int page, int size);
}
