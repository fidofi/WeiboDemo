package com.fidofi.dao;

import com.fidofi.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByNewsId(Integer newsId);

    Integer getCommentNum(Integer newsId);

    List<Comment> getUnRead(Integer newsId);

    int changeStatus(Integer commentid);


}