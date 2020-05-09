package com.melon.apk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Password {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    private String title;
    private String username;
    private String remark;
    private String pwd;
}
