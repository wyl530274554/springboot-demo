package com.melon.apk.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 拦截器管理
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    /**
     * 处理controller直接返回string会乱码的问题
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        addDefaultHttpMessageConverters(converters);
    }
}
