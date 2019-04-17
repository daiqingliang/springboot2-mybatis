package com.daiql.mybatis.bean;

import lombok.Data;

@Data
public class RegisterList{
	private Integer id;	//
	private String registerPlcAddr;	//
	private String registerProtocolAddr;	//
	private String registerTypeCode;	//
	private Integer deviceId;	//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegisterPlcAddr() {
        return registerPlcAddr;
    }

    public void setRegisterPlcAddr(String registerPlcAddr) {
        this.registerPlcAddr = registerPlcAddr;
    }

    public String getRegisterProtocolAddr() {
        return registerProtocolAddr;
    }

    public void setRegisterProtocolAddr(String registerProtocolAddr) {
        this.registerProtocolAddr = registerProtocolAddr;
    }

    public String getRegisterTypeCode() {
        return registerTypeCode;
    }

    public void setRegisterTypeCode(String registerTypeCode) {
        this.registerTypeCode = registerTypeCode;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
}