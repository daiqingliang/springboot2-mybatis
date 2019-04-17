package com.daiql.mybatis.mapper;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description:
 * @Author: daiql
 * @CreateDate: 2019/4/16$ 10:32 AM$
 * @Version: 1.0
 */

public interface CommonMapper<T> {

    int insert(T obj);

    int deleteById(int id);

    int update(T obj);

    T queryOne(int id);

    List<T> queryAll();
}
