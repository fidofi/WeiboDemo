package com.fidofi.controller;

import com.fidofi.constant.PhotoConstant;
import com.fidofi.dao.NewsMapper;
import com.fidofi.entity.News;
import com.fidofi.entity.User;
import com.fidofi.utils.PhotoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by fido on 2018/1/3.
 * 资讯相关
 */

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 发布资讯
     *
     * @param newstext
     * @param file
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/publish")
    public String publish(@RequestParam("newstext") String newstext,
                          @RequestParam("photo") MultipartFile file, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
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
            News news = new News();
            news.setNewstext(newstext);
            news.setNewsphoto("/" + user.getUsername() + filename);
            news.setUsername(user.getUsername());
            newsMapper.insert(news);
            return "/front/index";
        } else {
            News news = new News();
            news.setNewstext(newstext);
            news.setUsername(user.getUsername());
            newsMapper.insert(news);
            return "/front/index";
        }

    }
}
