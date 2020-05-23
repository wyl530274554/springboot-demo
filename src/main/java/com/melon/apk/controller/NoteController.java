package com.melon.apk.controller;

import com.melon.apk.entity.Note;
import com.melon.apk.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 示例
 */
@RestController
@RequestMapping("/topic")
public class NoteController {
    private NoteMapper noteMapper;

    @Autowired
    public void setNoteMapper(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    /**
     * 添加主题
     */
    @PostMapping
    public Object insert(Note note, HttpServletRequest request) {
        String remoteHost = request.getRemoteHost();
        note.setUser(remoteHost);
        return noteMapper.insert(note);
    }

    /**
     * 查看所有主题
     */
    @GetMapping
    public Object selectAll() {
        return noteMapper.selectList(null);
    }
}
