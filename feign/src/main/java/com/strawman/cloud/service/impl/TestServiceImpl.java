package com.strawman.cloud.service.impl;

import com.strawman.cloud.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestServiceImpl
 * @Author tao
 * @Date 2019/4/19 14:26
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String info() {
        return "ぺぺ strawman ぺぺ  这逼报错了，请求失败了，别请求了";
    }
}
