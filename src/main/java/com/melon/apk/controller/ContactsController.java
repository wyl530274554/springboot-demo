package com.melon.apk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melon.apk.entity.Contacts;
import com.melon.apk.mapper.ContactsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Object queryContacts(@PathVariable String content) {
        QueryWrapper<Contacts> query = new QueryWrapper<>();
        query.like("phone", content).or().like("name", content);
        return contactsMapper.selectList(query);
    }

    /**
     * 添加联系人
     */
    @PostMapping
    public Object addContacts(Contacts contacts){
        return contactsMapper.insert(contacts);
    }
}
