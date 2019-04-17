package com.daiql.mybatis.mapper;

import com.daiql.mybatis.bean.RegisterList;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: daiql
 * @CreateDate: 2019/4/16$ 10:30 AM$
 * @Version: 1.0
 */

@Mapper
@Component
public interface RegisterListMapper extends CommonMapper<RegisterList> {

    @Override
    @Insert(" insert into register_list (register_plc_addr,register_protocol_addr,register_type_code,device_id) " +
            " value " +
            " (#{registerPlcAddr}, #{registerProtocolAddr}, #{registerTypeCode}, #{deviceId}) ")
    int insert(RegisterList obj);

    @Override
    @Delete(" delete register_list where id = #{id}")
    int deleteById(int id);

    @Override
    @Update("update register_list set register_plc_addr = #{registerPlcAddr}, register_protocol_addr = #{registerProtocolAddr}, register_type_code = #{registerTypeCode}, device_id = #{deviceId}" +
            " where id = #{id}")
    int update(RegisterList obj);

    @Override
    @Select(" select * from register_list where id = #{id}")
    RegisterList queryOne(int id);

    @Override
    @Select(" select * from register_list order by id")
    List<RegisterList> queryAll();
}
