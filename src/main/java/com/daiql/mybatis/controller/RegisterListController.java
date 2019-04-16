package com.daiql.mybatis.controller;

import com.daiql.mybatis.bean.RegisterList;
import com.daiql.mybatis.mapper.RegisterListMapper;
import com.daiql.mybatis.util.JsonResult;
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
    private RegisterListMapper registerListMapper;

    @GetMapping("/registerList/{id}")
    public JsonResult queryOne(@PathVariable int id) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(registerListMapper.queryOne(id));
        jsonResult.setCode(200);
        jsonResult.setMsg("OK");
        return jsonResult;
    }

    @GetMapping("/registerList")
    public JsonResult queryAll() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(registerListMapper.queryAll());
        jsonResult.setCode(200);
        jsonResult.setMsg("OK");
        return jsonResult;
    }

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
        int num  = registerListMapper.insert(registerList);
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
        int num  = registerListMapper.update(registerList);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData("影响的行数：" + num);
        jsonResult.setCode(200);
        jsonResult.setMsg("OK");

        return jsonResult;
    }

    @DeleteMapping("/registerList")
    public JsonResult insert(@RequestParam(defaultValue = "") int id) {
        int num  = registerListMapper.deleteById(id);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData("影响的行数：" + num);
        jsonResult.setCode(200);
        jsonResult.setMsg("OK");
        return jsonResult;
    }

}
