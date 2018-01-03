package com.fidofi.controller;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.NewsMapper;
import com.fidofi.dao.UserMapper;
import com.fidofi.entity.News;
import com.fidofi.entity.User;
import com.fidofi.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by fido on 2018/1/3.
 * 搜索
 */
@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;


    @RequestMapping("/search")
    public String search(String search, HttpServletRequest request, HttpSession session) {
        User user=(User)session.getAttribute("user");
        ResultVO<Map<String, Object>> resultVO = searchService.search(search,user.getUsername());
        Map<String, Object> map = resultVO.getData();
        request.setAttribute("userList", map.get("userList"));
        request.setAttribute("newsList", map.get("newsList"));
        return "/front/search";
    }
}
