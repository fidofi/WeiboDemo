package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.CommentMapper;
import com.fidofi.dao.NewsMapper;
import com.fidofi.dao.UserMapper;
import com.fidofi.entity.Comment;
import com.fidofi.entity.News;
import com.fidofi.entity.Relay;
import com.fidofi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2018/1/5.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResultVO create(Comment comment) {
        int i = commentMapper.insert(comment);
        int j = newsMapper.createComment(comment.getNewsid());
        if (i > 0 && j > 0) {
            return ResultVO.createBySuccess("评论成功");
        } else {
            return ResultVO.createByError("评论失败");
        }
    }

    @Override
    public ResultVO<List<Comment>> selectByNewsId(Integer newsId) {
        List<Comment> commentList = commentMapper.selectByNewsId(newsId);
        if (commentList == null && commentList.size() == 0) {
            return ResultVO.createBySuccess("暂无评论");
        }
        return ResultVO.createBySuccess("获取评论列表成功", commentList);
    }

    @Override
    public ResultVO<List<Comment>> getUnRead(String userName) {
        List<Comment> commentList = new ArrayList<>();
        List<News> newsList = newsMapper.selectByUser(userName);
        if (newsList == null || newsList.size() == 0) {
            return ResultVO.createBySuccess("此用户还没用发过资讯");
        }
        //遍历
        for (News news : newsList) {
            List<Comment> currentCommentList = commentMapper.getUnRead(news.getNewsid());
            if (currentCommentList == null && currentCommentList.size() == 0) {
                continue;
            } else {
                commentList.addAll(currentCommentList);
            }
        }
        return ResultVO.createBySuccess("获取未读评论列表", commentList);
    }
}
