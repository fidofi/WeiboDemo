package com.fidofi.controller;

import com.fidofi.VO.ResultVO;
import com.fidofi.VO.UserVO;
import com.fidofi.dao.ManagerMapper;
import com.fidofi.entity.*;
import com.fidofi.service.ManagerService;
import com.fidofi.service.NewsService;
import com.fidofi.service.UserFreezeService;
import com.fidofi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2018/1/7.
 * 0代表超级管理员
 * 1代表用户管理员
 * 2代表资讯管理员
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private UserFreezeService userFreezeService;

    @RequestMapping("/login")
    public String login() {
        return "/back/login";
    }


    @RequestMapping("/index")
    public String index(Manager manager, HttpServletRequest request, HttpSession session) {
        ResultVO<Manager> resultVO = managerService.login(manager.getRootname(), manager.getRootpassword());
        if (resultVO.getData() == null) {
            request.setAttribute("loginMesg", resultVO.getMessage());
            return "/back/login";
        } else {
            session.setAttribute("manager", resultVO.getData());
            return "/back/index";
        }
    }

    //管理用户
    @RequestMapping("/manageUser")
    public String manageUser(HttpSession session, HttpServletRequest request) {
        Manager manager = (Manager) session.getAttribute("manager");
        if (manager.getRootpower() == 2) {
            request.setAttribute("powerMesg", "权限不允许进行此操作！");
            return "/back/index";
        }
        ResultVO<List<UserVO>> resultVO = userService.getAllUserList();
        request.setAttribute("userList", resultVO.getData());
        return "/back/manageuser";
    }

    //管理资讯
    @RequestMapping("/manageNews")
    public String manageNews(HttpSession session, HttpServletRequest request) {
        Manager manager = (Manager) session.getAttribute("manager");
        if (manager.getRootpower() == 1) {
            request.setAttribute("powerMesg", "权限不允许进行此操作！");
            return "/back/index";
        }
        ResultVO<List<News>> resultVO = newsService.getNewsList();
        request.setAttribute("newsList", resultVO.getData());
        return "/back/managenews";
    }

    //管理管理员
    @RequestMapping("/managePeople")
    public String managePeople(HttpSession session, HttpServletRequest request) {
        Manager manager = (Manager) session.getAttribute("manager");
        if (manager.getRootpower() != 0) {
            request.setAttribute("powerMesg", "权限不允许进行此操作！");
            return "/back/index";
        }
        ResultVO<List<Manager>> resultVO = managerService.getManagers();
        request.setAttribute("managerList", resultVO.getData());
        return "/back/managepeople";
    }

    //冻结用户
    @RequestMapping("/freeze")
    public String freeze(String username, String freezeresult, HttpSession session) {
        Manager manager = (Manager) session.getAttribute("manager");
        UserFreeze userFreeze = new UserFreeze();
        userFreeze.setUsername(username);
        userFreeze.setRootname(manager.getRootname());
        userFreeze.setFreezeresult(freezeresult);
        userFreezeService.freezeUser(userFreeze);
        return "redirect:/manager/manageUser";
    }


    @RequestMapping("/unfreeze")
    public String unfreeze(String username) {
        userFreezeService.unfreezeUser(username);
        return "redirect:/manager/manageUser";
    }

    @RequestMapping("/finduser")
    public String finduser(String username, HttpServletRequest request) {
        List<UserVO> userVOS = new ArrayList<>();
        UserVO user = userService.getUOneUser(username).getData();
        userVOS.add(user);
        request.setAttribute("userList", userVOS);
        return "/back/manageuser";
    }

    @RequestMapping("/deleteManager")
    public String deleteManager(String rootname) {
        return "redirect:/manager/managePeople";
    }

    @RequestMapping("/createManager")
    public String createManager(Manager manager) {
        managerService.create(manager);
        return "redirect:/manager/managePeople";
    }

    @RequestMapping("/createPage")
    public String createPage() {
        return "/back/createManager";
    }

    @RequestMapping("/signout")
    public String signout(HttpSession session){
        session.removeAttribute("manager");
        return "/back/login";
    }
}
