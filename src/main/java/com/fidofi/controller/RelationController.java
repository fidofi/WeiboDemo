package com.fidofi.controller;

import com.fidofi.dao.RelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by fido on 2018/1/3.
 * 处理关注和取关
 */
@Controller
@RequestMapping("/relation")
public class RelationController {


    @RequestMapping("/follow")
    public void follow(String secondUser, HttpSession session) {


    }

    @RequestMapping("/unfriend")
    public void unfriend() {

    }
}
