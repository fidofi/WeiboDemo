package com.fidofi.controller;

import com.fidofi.entity.Comment;
import com.fidofi.entity.User;
import com.fidofi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by fido on 2018/1/6.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/create")
    public String createComment(Integer newsId, String commentText, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        Comment comment=new Comment();
        comment.setCommenttext(commentText);
        comment.setNewsid(newsId);
        comment.setUsername(username);
        commentService.create(comment);
        return "forward:/user/index";
    }
}
