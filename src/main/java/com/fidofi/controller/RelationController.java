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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String follow(String secondUser, HttpSession session) {
        User user = (User) session.getAttribute("user");
        RelationKey relationKey = new RelationKey(user.getUsername(), secondUser);
        ResultVO resultVO = relationService.follow(relationKey);
        System.out.println(resultVO + "------关注结果");
        return "redirect:/user/index";
    }

    @RequestMapping("/getFollowers")
    public String getFollowers(String userName, HttpServletRequest request) {
        ResultVO<List<User>> resultVO = relationService.getFollowers(userName);
        request.setAttribute("followers", resultVO.getData());
        return "/front/followers";
    }

    @RequestMapping("/getFans")
    public String getFans(String userName, HttpServletRequest request) {
        ResultVO<List<User>> resultVO = relationService.getFans(userName);
        request.setAttribute("fans", resultVO.getData());
        return "/front/fans";
    }

    @RequestMapping("/unfollow")
    public String unfollow(String secondUser, HttpSession session) {
        User user = (User) session.getAttribute("user");
        RelationKey relationKey = new RelationKey(user.getUsername(), secondUser);
        ResultVO resultVO = relationService.unfollow(relationKey);
        System.out.println(resultVO + "------取关结果");
        return "redirect:/user/index";
    }

    @RequestMapping("/unfriend")
    public String unfriend(String secondUser, HttpSession session) {
        User user = (User) session.getAttribute("user");
        RelationKey relationKey = new RelationKey(user.getUsername(), secondUser);
        ResultVO resultVO = relationService.unfriend(relationKey);
        System.out.println(resultVO + "------移除粉丝结果");
        return "forward:/user/index";
    }
}
