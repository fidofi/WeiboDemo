package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.Comment;
import com.fidofi.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by fido on 2018/1/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {
    @Autowired
    private CommentService commentService;

    @Test
    public void create() throws Exception {
        Comment comment = new Comment();
        comment.setUsername("测试");
        comment.setNewsid(5);
        comment.setCommenttext("测试评论112111");
        ResultVO resultVO = commentService.create(comment);
        System.out.println(resultVO);
    }

    @Test
    public void selectByNewsId() throws Exception {
        ResultVO<List<Comment>> resultVO = commentService.selectByNewsId(3);
        for (Comment comment : resultVO.getData()) {
            System.out.println(comment);
        }
    }

    @Test
    public void getUnRead() throws Exception {
        ResultVO<List<Comment>> resultVO = commentService.getUnRead("fidofi");
        for (Comment comment : resultVO.getData()) {
            System.out.println(comment);
        }
    }

}