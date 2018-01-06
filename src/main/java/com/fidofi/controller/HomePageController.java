package com.fidofi.controller;

import com.fidofi.VO.NewsAndeUser;
import com.fidofi.VO.RelayVO;
import com.fidofi.VO.ResultVO;
import com.fidofi.dao.UserMapper;
import com.fidofi.entity.Relay;
import com.fidofi.entity.User;
import com.fidofi.service.HomePageService;
import com.fidofi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by fido on 2018/1/6.
 */
@Controller
@RequestMapping("/homepage")
public class HomePageController {
    @Autowired
    private HomePageService homePageService;
    @Autowired
    private UserService userService;

    @RequestMapping("/myOwn")
    public String getOwn(String username, HttpServletRequest request) {
        List<NewsAndeUser> newsAndeUserList = homePageService.getNews(username).getData();
        List<RelayVO> relayVOList = homePageService.getRelay(username).getData();
        User user = userService.findUserByName(username).getData();
        request.setAttribute("newsList", newsAndeUserList);
        request.setAttribute("currentUser", user);
        request.setAttribute("relayList",relayVOList);
        return "/front/homePage";
    }
}
