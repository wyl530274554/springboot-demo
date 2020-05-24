package com.melon.apk.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 访问拦截
 */
@Component
public class VisitorInterceptor implements HandlerInterceptor {
    /**
     * 超过此时间算频繁访问
     */
    private static final long MAX_TIME_IN_MILLIS = 500;

    /**
     * 请求信息
     * key: uri
     * value: 访问时间
     */
    private Map<String, Long> visitors = new HashMap<>();

    /**
     * 预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean ret = true;

        long curTime = System.currentTimeMillis();
        String requestURI = request.getRequestURI();
        String method = request.getMethod();

        String key = requestURI + method;
        if (visitors.containsKey(key)) {
            //已经访问过
            long preTime = visitors.get(key);
            long durTime = curTime - preTime;

            if (durTime < MAX_TIME_IN_MILLIS) {
                //请求的太快
                System.out.println("请求太快：" + durTime + ", uri: " + key);
                ret = false;
            }
        }
        visitors.put(key, curTime);
        return ret;
    }
}
