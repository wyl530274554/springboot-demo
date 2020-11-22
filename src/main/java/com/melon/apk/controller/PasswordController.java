package com.melon.apk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melon.apk.entity.Contacts;
import com.melon.apk.entity.Password;
import com.melon.apk.mapper.PasswordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/password")
@RestController
public class PasswordController {
    private PasswordMapper passwordMapper;

    @Autowired
    public void setPasswordMapper(PasswordMapper passwordMapper) {
        this.passwordMapper = passwordMapper;
    }

    /**
     * RESTFUL风格
     * api里的动作描述用GET/POST/PUT/DELETE来处理
     * patch局部更新
     * put完整更新
     */
    @GetMapping("/all")
    public Object getAllPassword() {
        return passwordMapper.selectList(null);
    }

    /**
     * 查询
     * 模糊
     */
    @GetMapping("/{content}")
    public Object queryContacts(@PathVariable String content) {
        QueryWrapper<Password> query = new QueryWrapper<>();
        query.like("title", content);
        return passwordMapper.selectList(query);
    }

    /**
     * 更新密码
     * 注@RequestBody 会将请求体中的JSON封装为这里的对象
     */
    @PatchMapping
    public Object updatePassword(@RequestBody Password password) {
        return passwordMapper.updateById(password);
    }

    /**
     * 增加
     * Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported
     * 不要加@RequestBody注解
     */
    @PostMapping
    public Object addPassword(Password password) {
        return passwordMapper.insert(password);
    }
}
