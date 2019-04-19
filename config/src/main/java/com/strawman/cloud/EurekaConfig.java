package com.strawman.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName EurekaConfig
 * @Author tao
 * @Date 2019/4/19 15:17
 * @Version 1.0
 */
@SpringCloudApplication
@EnableConfigServer//声明配置中心开启
public class EurekaConfig {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfig.class,args);
    }
}
