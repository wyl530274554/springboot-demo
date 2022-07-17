package com.melon.apk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Money {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    private String title;
    private int level;
    private int amount;
    @TableField(exist = false)
    private int ratio;
}