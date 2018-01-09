package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.Comment;

import java.util.List;

/**
 * Created by fido on 2018/1/5.
 */
public interface CommentService {

    /**
     * 创建评论
     * @param comment
     * @return
     */
    public ResultVO create(Comment comment);

    /**
     * 查找该资讯下的评论
     * @param newsId
     * @return
     */
    public ResultVO<List<Comment>> selectByNewsId(Integer newsId);


    /**
     * 用户的未读评论通知
     * @param userName
     * @return
     */
    public ResultVO<List<Comment>> getUnRead(String userName);

    /**
     * 读评论
     * @param commentid
     * @return
     */
    public ResultVO doReadComment(Integer commentid);
}
