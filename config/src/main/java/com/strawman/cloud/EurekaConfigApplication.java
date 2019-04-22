package com.strawman.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName EurekaConfig
 * @Author tao
 * @Date 2019/4/19 15:17
 * @Version 1.0
 */
@SpringCloudApplication
@EnableConfigServer//声明配置中心开启
public class EurekaConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigApplication.class,args);
    }
}
