package com.strawman.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @ClassName EurekaCilentApplication
 * @Author tao
 * @Date 2019/4/18 10:16
 * @Version 1.0
 */
@SpringCloudApplication
public class EurekaCilentTourApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCilentTourApplication.class,args);
    }
}
