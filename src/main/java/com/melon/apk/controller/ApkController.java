package com.melon.apk.controller;

import ch.qos.logback.core.rolling.helper.FileStoreUtil;
import ch.qos.logback.core.util.FileUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melon.apk.entity.Apk;
import com.melon.apk.mapper.ApkMapper;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.FileSystem;

/**
 * APK管理
 */
@RestController
@RequestMapping
public class ApkController {
    @Autowired
    private ApkMapper apkMapper;

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

    /**
     * 上传APK文件
     */
    @CrossOrigin
    @PostMapping("/apk")
    public Object insertApkVersion(Apk apk, MultipartFile apkFile) throws Exception {
        File file = new File("/home/melon/files"+apk.getName());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(apkFile.getBytes());
        fileOutputStream.close();
        return apkMapper.insert(apk);
    }
}
