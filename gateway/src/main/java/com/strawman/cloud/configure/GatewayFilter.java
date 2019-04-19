package com.strawman.cloud.configure;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GatewayFilter
 * @Author tao
 * @Date 2019/4/18 14:47
 * @Version 1.0
 */
@Component
public class GatewayFilter implements GlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(GatewayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       List<String> token = exchange.getRequest().getHeaders().get("token");
       log.info("-----------strawman Filter 打印："+token);
       boolean authorityflag = false;
       if(token != null){//不等于null继续校验


       }

       if(!authorityflag){
           //创建返回的response
           ServerHttpResponse response = exchange.getResponse();
           Map<String,Object> message = new HashMap<>();
           message.put("status", -1);
           message.put("data", "鉴权失败");
           byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
           DataBuffer buffer = response.bufferFactory().wrap(bits);
           response.setStatusCode(HttpStatus.UNAUTHORIZED);
           response.getHeaders().add("Content-Type", "text/json;charset=UTF-8");
           return response.writeWith(Mono.just(buffer));
       }
        return chain.filter(exchange);
    }
}
