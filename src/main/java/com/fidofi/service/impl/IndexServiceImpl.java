package com.fidofi.service.impl;

import com.fidofi.VO.NewsAndeUser;
import com.fidofi.VO.RelayVO;
import com.fidofi.VO.ResultVO;
import com.fidofi.dao.*;
import com.fidofi.entity.News;
import com.fidofi.entity.Relation;
import com.fidofi.entity.Relay;
import com.fidofi.entity.User;
import com.fidofi.service.IndexService;
import com.fidofi.service.RelationService;
import com.fidofi.utils.RelationUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2018/1/6.
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private RelayMapper relayMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private RelationMapper relationMapper;


    @Override
    public ResultVO<List<NewsAndeUser>> getNewsByFollow(String userName) {
        //获得关注人列表
        List<Relation> relationList = relationMapper.getFollowers(userName);
        List<User> userList = RelationUtils.getUserListFromRelation(relationList, userName, userMapper);
        if (userList == null || userList.size() == 0) {
            return ResultVO.createBySuccess("暂无关注的用户");
        }
        List<NewsAndeUser> newsList = new ArrayList<>();
        for (User user : userList) {
            List<NewsAndeUser> newsAndeUsers = new ArrayList<>();
            List<News> newsList1 = newsMapper.selectByUser(user.getUsername());
            for (News news : newsList1) {
                NewsAndeUser newsAndeUser = new NewsAndeUser();
                newsAndeUser.setUser(userMapper.selectByPrimaryKey(news.getUsername()));
                newsAndeUser.setNewsid(news.getNewsid());
                newsAndeUser.setCommentList(commentMapper.selectByNewsId(news.getNewsid()));
                newsAndeUser.setNewscomment(news.getNewscomment());
                newsAndeUser.setNewslike(news.getNewslike());
                newsAndeUser.setNewsrelay(news.getNewsrelay());
                newsAndeUser.setNewstime(news.getNewstime());
                newsAndeUser.setNewstext(news.getNewstext());
                newsAndeUser.setNewsphoto(news.getNewsphoto());
                newsAndeUser.setNewsstatus(news.getNewsstatus());
                newsAndeUsers.add(newsAndeUser);
            }
            newsList.addAll(newsAndeUsers);
        }
        if (newsList.size() == 0) {
            return ResultVO.createBySuccess("关注的用户暂未有资讯");
        }
        return ResultVO.createBySuccess("获得资讯成功", newsList);
    }

    @Override
    public ResultVO<List<RelayVO>> getRelayByUser(String userName) {
        //获得关注人列表
        List<Relation> relationList = relationMapper.getFollowers(userName);
        List<User> userList = RelationUtils.getUserListFromRelation(relationList, userName, userMapper);
        List<Relay> relayList = new ArrayList<>();
        if (userList == null || userList.size() == 0) {
            return ResultVO.createBySuccess("暂无关注的用户");
        }
        for (User user : userList) {
            List<Relay> relayList1 = relayMapper.getRelayByUser(user.getUsername());
            relayList.addAll(relayList1);
        }
        if (relayList.size() == 0) {
            return ResultVO.createBySuccess("关注的用户暂无转发信息");
        }
        List<RelayVO> relayVOList = new ArrayList<>();
        for (Relay relay : relayList) {
            RelayVO relayVO = new RelayVO();
            News news = newsMapper.selectByPrimaryKey(relay.getNewsid());
            relayVO.setUsername(relay.getUsername());
            relayVO.setNews(news);
            if (relay.getRelaytext() == null) {
                relayVO.setRelaytext("转发");
            } else {
                relayVO.setRelaytext(relay.getRelaytext());
            }
            relayVO.setRelayid(relay.getRelayid());
            relayVO.setRelaystatus(relay.getRelaystatus());
            relayVO.setRelaytime(relay.getRelaytime());

            relayVOList.add(relayVO);
        }
        return ResultVO.createBySuccess("查找关注用户转发消息成功", relayVOList);
    }
}
