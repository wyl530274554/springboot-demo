package com.melon.apk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例
 */
@RestController
@RequestMapping("/foo")
public class FooController {
    /**
     * 服务在线查询
     */
    @GetMapping
    public Object isServerOnline() {
        return true;
    }
}
