package com.melon.apk.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器管理
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    private VisitorInterceptor visitorInterceptor;

    @Autowired
    public void setVisitorInterceptor(VisitorInterceptor visitorInterceptor) {
        this.visitorInterceptor = visitorInterceptor;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(visitorInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
