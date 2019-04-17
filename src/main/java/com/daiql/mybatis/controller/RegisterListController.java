package com.daiql.mybatis.controller;

import com.daiql.mybatis.bean.RegisterList;
import com.daiql.mybatis.mapper.RegisterListMapper;
import com.daiql.mybatis.service.RegisterListServiceImpl;
import com.daiql.mybatis.service.TestService;
import com.daiql.mybatis.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: daiql
 * @CreateDate: 2019/4/16 10:47 AM
 * @Version: 1.0
 */

@RestController
public class RegisterListController {

    @Autowired
    private RegisterListServiceImpl registerListService;

//    @Autowired
//    private TestService testService;

//    @Autowired
//    private RegisterListMapper registerListMapper;

    @GetMapping("/registerList/{id}")
    public JsonResult queryOne(@PathVariable int id) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(registerListService.queryOne(id));
        jsonResult.setCode(200);
        jsonResult.setMsg("OK");
        return jsonResult;
    }

//    @GetMapping("/registerList")
//    public JsonResult queryAll() {
//        JsonResult jsonResult = new JsonResult();
//        jsonResult.setData(registerListMapper.queryAll());
//        jsonResult.setCode(200);
//        jsonResult.setMsg("OK");
//        return jsonResult;
//    }


    /**
     *
     * 功能描述: 第二种方式整合PageHelper
     * ----通过写Service接口和ServiceImpl实现类来实现分页----
     * 主要相关类：
     * 1、com.daiql.mybatis.service.RegisterListService 服务接口
     * 2、com.daiql.mybatis.service.RegisterListServiceImpl 接口实现类，通过对RegisterListMapper的queryAll()方法的返回
     *    List<RegisterList> 重新封装到PageInfo<RegisterList>中
     *
     * @return: JsonResult
     * @auther: daiql
     * @date:   2019/4/17 8:54 AM
     */
    @GetMapping("/registerList")
    public JsonResult queryAll() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(200);
        jsonResult.setMsg("OK");
        PageInfo<RegisterList> pageInfo = registerListService.queryAll(1,10);
        jsonResult.setData(pageInfo);
        return jsonResult;
    }

    /**
     *
     * 功能描述: 第一种方式整合PageHelper
     * ----使用AOP拦截----
     * 主要相关类：
     * 1、com.daiql.mybatis.annotatian.ExtPageHelper 自定义接口，设置默认分页页数
     * 2、com.daiql.mybatis.aspect.PageHelperAspect 自定义拦截类
     * 3、com.daiql.mybatis.service.TestService 类中的queryAll()实现分页
     *
     * @return: com.daiql.mybatis.util.JsonResult
     * @auther: daiql
     * @date:   2019/4/17 8:48 AM
     */

//    @GetMapping("/registerList")
//    public JsonResult queryAll() {
//        JsonResult jsonResult = new JsonResult();
//        jsonResult.setCode(200);
//        jsonResult.setMsg("OK");
//        PageInfo<RegisterList> pageInfo = (PageInfo<RegisterList>)testService.queryAll(1,10);
//        jsonResult.setData(pageInfo);
//        return jsonResult;
//    }

    @PostMapping("/registerList")
    public JsonResult insert(
            @RequestParam(defaultValue = "") String registerPlcAddr,
            @RequestParam(defaultValue = "") String registerProtocolAddr,
            @RequestParam(defaultValue = "") String registerTypeCode,
            @RequestParam(defaultValue = "0") int deviceId) {
        RegisterList registerList = new RegisterList();
        registerList.setRegisterPlcAddr(registerPlcAddr);
        registerList.setRegisterProtocolAddr(registerProtocolAddr);
        registerList.setRegisterTypeCode(registerTypeCode);
        registerList.setDeviceId(deviceId);
        int num  = registerListService.insert(registerList);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData("影响的行数：" + num);
        jsonResult.setCode(200);
        jsonResult.setMsg("OK");

        return jsonResult;
    }

    @PutMapping("/registerList")
    public JsonResult insert(
            @RequestParam(defaultValue = "") String registerPlcAddr,
            @RequestParam(defaultValue = "") String registerProtocolAddr,
            @RequestParam(defaultValue = "") String registerTypeCode,
            @RequestParam(defaultValue = "") int deviceId,
            @RequestParam(defaultValue = "") int id) {
        RegisterList registerList = new RegisterList();
        registerList.setId(id);
        registerList.setRegisterPlcAddr(registerPlcAddr);
        registerList.setRegisterProtocolAddr(registerProtocolAddr);
        registerList.setRegisterTypeCode(registerTypeCode);
        registerList.setDeviceId(deviceId);
        int num  = registerListService.update(registerList);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData("影响的行数：" + num);
        jsonResult.setCode(200);
        jsonResult.setMsg("OK");

        return jsonResult;
    }

    @DeleteMapping("/registerList")
    public JsonResult insert(@RequestParam(defaultValue = "") int id) {
        int num  = registerListService.deleteById(id);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData("影响的行数：" + num);
        jsonResult.setCode(200);
        jsonResult.setMsg("OK");
        return jsonResult;
    }

}
