package com.strawman.cloud.exception;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JsonExceptionHandler
 * @Author tao
 * @Date 2019/4/18 17:09
 * @Version 1.0
 */
public class JsonExceptionHandler extends DefaultErrorWebExceptionHandler {

    /**
     * Create a new {@code DefaultErrorWebExceptionHandler} instance.
     *
     * @param errorAttributes    the error attributes
     * @param resourceProperties the resources configuration properties
     * @param errorProperties    the error configuration properties
     * @param applicationContext the current application context
     */
    public JsonExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }

    /**
     * 获取异常属性
     * @param request
     * @param includeStackTrace
     * @return
     */
    protected Map<String, Object> getErrorAttributes(ServerRequest request,boolean includeStackTrace) {
        int code = 500;
        Throwable error = super.getError(request);
        System.out.println(" ぺぺ strawman ぺぺ 打印 ："+error.getMessage());
        System.out.println(" ぺぺ strawman ぺぺ 打印 ："+error.getLocalizedMessage());
        if (error instanceof org.springframework.cloud.gateway.support.NotFoundException
        || error instanceof org.springframework.web.server.ResponseStatusException ) {
            code = 404;
        }
        return this.response(code, this.buildMessage(request, error));
    }

    /**
     * 指定响应处理方法为 JSON 处理的方法
     * @param errorAttributes
     */
    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }


    /**
     * 根据 code 获取对应的 HttpStatus
     * @param errorAttributes
     */
    @Override
    protected HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {
        int statusCode = (int) errorAttributes.get("code");
        return HttpStatus.valueOf(statusCode);
    }

    /**
     * 构建异常信息
     * @param request
     * @param ex
     * @return
     */
    private String buildMessage(ServerRequest request, Throwable ex) {
        StringBuilder message = new StringBuilder("Failed to handle request [");
        message.append(request.methodName());
        message.append(" ");
        message.append(request.uri());
        message.append(" ");
        message.append(request.queryParams().toString());
        message.append("]");
        if (ex != null) {
            message.append(": ");
            message.append(ex.getMessage());
        }
        return message.toString();
    }

    /**
     * 构建返回的 JSON 数据格式
     * @param code        状态码
     * @param errorMessage  异常信息
     * @return
     */
    public static Map<String, Object> response(int code, String errorMessage) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", errorMessage);
        return map;
    }

}
