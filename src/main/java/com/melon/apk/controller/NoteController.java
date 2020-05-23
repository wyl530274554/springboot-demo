package com.melon.apk.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melon.apk.entity.Note;
import com.melon.apk.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 示例
 */
@Controller
@RequestMapping("/topic")
public class NoteController {
    private NoteMapper noteMapper;
    private List<Note> topics = new ArrayList<>();

    @Autowired
    public void setNoteMapper(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    /**
     * 跳转
     */
    @GetMapping
    public String index(Model model) {
        if (topics.isEmpty()) {
            //读取数据库
            topics = selectAll();
        }

        model.addAttribute("topics", topics);
        return "topic";
    }

    /**
     * 添加主题
     */
    @PostMapping
    public void insert(Note note, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String sessionId = request.getSession().getId();
        note.setUser(sessionId == null ? "访客：" : "访客：" + sessionId.substring(0, 5));
        if(StringUtils.isEmpty(note.getContent())) {
            note.setContent("此人是傻吊，不写内容");
        }

        noteMapper.insert(note);
        topics = selectAll();
        model.addAttribute("topics", topics);

        //解决重复提交表单问题，return "topic"F5刷新时会提示重复提交表单
        response.sendRedirect("topic");
    }

    /**
     * 查看所有主题
     */
    @GetMapping("/all")
    public List<Note> selectAll() {
        Integer count = noteMapper.selectCount(null);
        QueryWrapper<Note> query = new QueryWrapper<>();
        int start = count - 10;
        if (start < 0) start = 0;
        String sql = "limit " + start + ", 10";
        System.out.println("sql: " + sql);
        query.last(sql);
        return noteMapper.selectList(query);
    }
}
