package com.strawman.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName EurekaFeginApplication
 * @Author tao
 * @Date 2019/4/19 13:19
 * @Version 1.0
 */
@SpringCloudApplication
@EnableFeignClients//声明式 HTTP 客户端 开启OpenFegin
@EnableHystrixDashboard//声明开启 熔断器 的dashboard
public class EurekaFeginApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaFeginApplication.class,args);
    }

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet );
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
