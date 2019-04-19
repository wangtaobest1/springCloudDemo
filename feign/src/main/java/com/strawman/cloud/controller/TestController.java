package com.strawman.cloud.controller;

import com.strawman.cloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Author tao
 * @Date 2019/4/19 14:30
 * @Version 1.0
 */
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private TestService t;

    @RequestMapping("info")
    @ResponseBody
    public String info(){
      return  t.info();
    }

}
