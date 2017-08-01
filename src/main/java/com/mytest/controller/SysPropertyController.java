package com.mytest.controller;

import com.mytest.pojo.SysProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Neil.jia on 2017/8/1.
 */
@Controller
public class SysPropertyController {

    @Value("${jdbc.driver}")
    private String dbDriver;
    @Value("${jdbc.url}")
    private String dbUrl;
    @Value("${jdbc.username}")
    private String dbUsername;
    @Value("${jdbc.password}")
    private String dbPassword;
    @Value("${env.name}")
    private String envName;

    @RequestMapping(value = "/sysProperty/config")
    public String dbConfig(ModelMap modelMap){
        //建立系统参数对象
        SysProperties properties = new SysProperties();
        properties.setDriver(dbDriver);
        properties.setUrl(dbUrl);
        properties.setUsername(dbUsername);
        properties.setPassword(dbPassword);
        properties.setEnvName(envName);
        modelMap.put("properties", properties );
        return "sysProperty/info";
    }
}
