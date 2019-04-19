package com.strawman.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @ClassName GatewayApplication
 * @Author tao
 * @Date 2019/4/18 13:52
 * @Version 1.0
 */
@SpringCloudApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
