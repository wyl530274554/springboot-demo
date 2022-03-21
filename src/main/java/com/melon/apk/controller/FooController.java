package com.melon.apk.controller;

import com.melon.apk.util.SystemUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例
 */
@RestController
@RequestMapping("/")
public class FooController {
    /**
     * 服务在线查询
     */
    @GetMapping
    public Object isServerOnline() {
        return true;
    }

    /**
     * CPU信息
     */
    @GetMapping("/cpu")
    public Object getCpuInfo() {
        int count = SystemUtil.getSystemCpuCount();
        double systemCpuLoad = SystemUtil.getSystemCpuLoad();
        int memoryLoad = SystemUtil.getMemoryLoad();
        return "cpu count: " + count + ", cpuLoad: " + (int) (systemCpuLoad * 100) + ", memoryLoad:" + memoryLoad;
    }
}
