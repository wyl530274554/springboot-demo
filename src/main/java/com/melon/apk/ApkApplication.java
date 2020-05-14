package com.melon.apk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 入口
 *
 * 若要将项目部署到tomcat中，需要继承至SpringBootServletInitializer
 * 否则找不到入口
 */
@MapperScan("com.melon.apk.mapper")
@SpringBootApplication
public class ApkApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApkApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApkApplication.class, args);
    }
}
