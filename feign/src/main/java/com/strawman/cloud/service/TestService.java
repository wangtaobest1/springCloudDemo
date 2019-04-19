package com.strawman.cloud.service;

import com.strawman.cloud.service.impl.TestServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestService
 * @Author tao
 * @Date 2019/4/19 13:21
 * @Version 1.0
 */
@FeignClient(value = "eurekaclient",fallback = TestServiceImpl.class)
public interface TestService {

    @RequestMapping("/actuator/info")
    public String info();
}
