package com.strawman.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Author tao
 * @Date 2019/4/18 10:29
 * @Version 1.0
 */
@RequestMapping("actuator")
@RestController
public class TestController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("info")
    @ResponseBody
    public String test(){
        return "欢迎访问小峰峰！ port : "+port;
    }
}
