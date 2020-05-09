package com.melon.apk.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melon.apk.entity.Contacts;
import com.melon.apk.mapper.ContactsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/contacts")
@RestController
public class ContactsController {
    private ContactsMapper contactsMapper;

    @Autowired
    public void setContactsMapper(ContactsMapper contactsMapper) {
        this.contactsMapper = contactsMapper;
    }

    /**
     * 查询联系人
     * phone name模糊
     */
    @GetMapping("/{content}")
    public Object selectContacts(@PathVariable String content) {
        QueryWrapper<Contacts> query = new QueryWrapper<>();
        query.like("phone", content).or().like("name", content);
        return contactsMapper.selectList(query);
    }
}
