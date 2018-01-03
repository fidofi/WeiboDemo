package com.fidofi.controller;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.User;
import com.fidofi.enums.ResponseCode;
import com.fidofi.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by fido on 2018/1/2.
 * 用户控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String index() {
        return "/front/signin";
    }

    @RequestMapping("/index")
    public String login(User user, HttpServletRequest request, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "/front/index";
        }

        if (StringUtils.isBlank(user.getUsername())) {
            request.setAttribute("loginMesg", "用户名不能为空");
            return "/front/signin";
        }
        if (StringUtils.isBlank(user.getUserpassword())) {
            request.setAttribute("loginMesg", "密码不能为空");
            return "/front/signin";
        }
        ResultVO<User> resultVO = userService.login(user.getUsername(), user.getUserpassword());
        if (resultVO.getData() == null) {
            request.setAttribute("loginMesg", resultVO.getMessage());
            return "/front/signin";
        }
        //登录成功
        session.setAttribute("user", user);
        return "/front/index";
    }

    @RequestMapping("/register")
    public String register(User user, String cconfirmpassword, HttpServletRequest request) {
        if (!user.getUserpassword().equals(cconfirmpassword)) {
            request.setAttribute("registerMesg", "两次密码不一致");
            return "/front/signin";
        }
        ResultVO resultVO = userService.register(user);
        if (resultVO.getCode() == ResponseCode.ERROR.getCode()) {
            request.setAttribute("registerMesg", resultVO.getMessage());
            return "/front/signin";
        }
        return "/front/signin";
    }

    @RequestMapping("/setting")
    public String setting(HttpServletRequest request, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        ResultVO<User> resultVO = userService.findUserByName(currentUser.getUsername());
        if (resultVO.getData() == null) {
            return "/front/index";
        } else {
            request.setAttribute("updateUser", resultVO.getData());
            return "/front/setting";
        }
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        ResultVO<User> resultVO = userService.update(user);
        if (resultVO.getData() == null) {
            return "/front/index";
        } else {
            return "forward:/user/setting";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "/front/signin";
    }
}
