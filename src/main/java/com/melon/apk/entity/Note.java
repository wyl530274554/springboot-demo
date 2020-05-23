package com.melon.apk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Note {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    private String content;
    private String user;
    private String createTime;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
