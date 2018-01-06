package com.fidofi.dao;

import com.fidofi.entity.News;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsid);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsid);

    List<News> selectByNewstext(@Param("newstext") String newstext);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> selectByUser(String userName);

    int createRelay(Integer newsId);

    int deleteRelay(Integer newsId);

    int createComment(Integer newsId);

    int delteComment(Integer newsId);


}