package com.fidofi.controller;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.RelationMapper;
import com.fidofi.entity.RelationKey;
import com.fidofi.entity.User;
import com.fidofi.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by fido on 2018/1/3.
 * 处理关注和取关
 */
@Controller
@RequestMapping("/relation")
public class RelationController {

    @Autowired
    private RelationService relationService;

    @RequestMapping("/follow")
    public void follow(String secondUser, HttpSession session) {
        System.out.println("进来了");
        User user = (User) session.getAttribute("user");
        RelationKey relationKey = new RelationKey(user.getUsername(), secondUser);
        ResultVO resultVO = relationService.follow(relationKey);
        System.out.println(resultVO + "------关注结果");
    }

    @RequestMapping("/unfollow")
    public void unfollow(String secondUser, HttpSession session) {
        User user = (User) session.getAttribute("user");
        RelationKey relationKey = new RelationKey(user.getUsername(), secondUser);
        ResultVO resultVO = relationService.unfollow(relationKey);
        System.out.println(resultVO + "------取关结果");

    }

    @RequestMapping("/unfriend")
    public void unfriend(String secondUser, HttpSession session) {
        User user = (User) session.getAttribute("user");
        RelationKey relationKey = new RelationKey(user.getUsername(), secondUser);
        ResultVO resultVO = relationService.unfriend(relationKey);
        System.out.println(resultVO + "------移除粉丝结果");
    }
}
