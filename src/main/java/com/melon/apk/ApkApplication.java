package com.melon.apk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.melon.apk.mapper")
@SpringBootApplication
public class ApkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApkApplication.class, args);
    }

}
