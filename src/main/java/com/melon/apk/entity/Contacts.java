package com.melon.apk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Contacts {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    private String name;
    private String phone;
}
