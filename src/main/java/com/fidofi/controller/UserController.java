package com.fidofi.controller;

import com.fidofi.VO.NewsAndeUser;
import com.fidofi.VO.RelayVO;
import com.fidofi.VO.ResultVO;
import com.fidofi.constant.PhotoConstant;
import com.fidofi.entity.News;
import com.fidofi.entity.Relay;
import com.fidofi.entity.User;
import com.fidofi.enums.ResponseCode;
import com.fidofi.service.*;
import com.fidofi.utils.PhotoUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by fido on 2018/1/2.
 * 用户控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private IndexService indexService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RelayService relayService;


    @RequestMapping("/login")
    public String index() {
        return "/front/signin";
    }

    //登录成功后要把该用户关注的用户的资讯和自己的资讯展示出来
    //包括转发的
    @RequestMapping("/index")
    public String login(User user, HttpServletRequest request, HttpSession session) {
        ResultVO<User> resultVO = null;
        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            session.setAttribute("user", user);
        } else {
            if (StringUtils.isBlank(user.getUsername())) {
                request.setAttribute("loginMesg", "用户名不能为空");
                return "/front/signin";
            }
            if (StringUtils.isBlank(user.getUserpassword())) {
                request.setAttribute("loginMesg", "密码不能为空");
                return "/front/signin";
            }
            resultVO = userService.login(user.getUsername(), user.getUserpassword());
            if (resultVO.getData() == null) {
                request.setAttribute("loginMesg", resultVO.getMessage());
                return "/front/signin";
            } else {
                //登录成功
                session.setAttribute("user", resultVO.getData());
            }
        }
        ResultVO<List<NewsAndeUser>> resultVO1 = indexService.getNewsByFollow(user.getUsername());
        ResultVO<List<RelayVO>> resultVO2 = indexService.getRelayByUser(user.getUsername());
        request.setAttribute("followNews", resultVO1.getData());
        request.setAttribute("followRelays", resultVO2.getData());
        return "/front/index";
    }

    @RequestMapping("/register")
    public String register(User user, String confirmpassword, HttpServletRequest request) {
        System.out.println(user.getUserpassword() + "---" + confirmpassword);
        if (!user.getUserpassword().equals(confirmpassword)) {
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

    //更改密码
    @RequestMapping("/changePassword")
    public String changePassword(String oldPassword, String newPassword, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        ResultVO resultVO = userService.changePassword(username, oldPassword, newPassword);
        request.setAttribute("chanageResult", resultVO.getMessage());
        request.setAttribute("code", resultVO.getCode());
        return "/front/changepassword";

    }

    //跳转到更改密码界面
    @RequestMapping("/changePassPage")
    public String changePassPage() {
        return "/front/changepassword";
    }

    //查看通知
    @RequestMapping("/getNotice")
    public String getNotice() {


        return "";
    }


    //更改头像
    @RequestMapping("/changePhoto")
    public String changePhoto(@RequestParam("userphoto") MultipartFile file, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");
        //如果文件不为空，写入上传路径
        //获得用户名
        String username = user.getUsername();
        //上传文件路径
        String path = PhotoConstant.PHOTO_LOCALTION + "//" + username;
        //上传文件名
        String filename = PhotoUtils.getPhotoName() + ".jpg";
        File filepath = new File(path, filename);
        //判断路径是否存在，如果不存在就创建一个
        //为每个用户创建一个目录
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文件当中
        file.transferTo(new File(path + File.separator + filename));
        userService.changePhoto(username + "/" + filename, username);
        return "redirect:/user/index";
    }


    //转发
    @RequestMapping("/relayNews")
    public String relayNews(Integer newsId, String relayText, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Relay relay = new Relay();
        relay.setNewsid(newsId);
        relay.setUsername(user.getUsername());
        relay.setRelaytext(relayText);
        ResultVO resultVO = relayService.create(relay);
        return "redirect:/user/index";
    }
}
