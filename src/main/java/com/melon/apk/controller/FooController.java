package com.melon.apk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melon.apk.entity.Apk;
import com.melon.apk.mapper.ApkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例
 */
@RestController
@RequestMapping("/")
public class FooController {
    @Autowired
    private ApkMapper apkMapper;

    /**
     * 服务在线查询
     */
    @GetMapping
    public Object isServerOnline() {
        return true;
    }

    /**
     * 升级查询
     */
    @GetMapping("/upgrade")
    public Object queryApkVersion() {
        QueryWrapper<Apk> queryMapper = new QueryWrapper<>();
        queryMapper.orderByDesc("id");
        queryMapper.last("limit 1");
        return apkMapper.selectOne(queryMapper);
    }
}
