package com.melon.apk.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melon.apk.entity.Note;
import com.melon.apk.entity.Password;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteMapper extends BaseMapper<Note> {
}
