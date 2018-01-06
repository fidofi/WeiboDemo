package com.fidofi.service.impl;

import com.fidofi.VO.NewsAndeUser;
import com.fidofi.VO.RelayVO;
import com.fidofi.VO.ResultVO;
import com.fidofi.dao.CommentMapper;
import com.fidofi.dao.NewsMapper;
import com.fidofi.dao.RelayMapper;
import com.fidofi.entity.News;
import com.fidofi.entity.Relay;
import com.fidofi.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2018/1/6.
 */
@Service
public class HomePageServiceImpl implements HomePageService {
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private RelayMapper relayMapper;

    @Override
    public ResultVO<List<NewsAndeUser>> getNews(String username) {
        List<News> newsList = newsMapper.selectByUser(username);
        if (newsList == null || newsList.size() == 0) {
            return ResultVO.createBySuccess("该用户暂无原创资讯");
        }
        List<NewsAndeUser> newsAndeUsers = new ArrayList<>();
        for (News news : newsList) {
            NewsAndeUser newsAndeUser = new NewsAndeUser();
            newsAndeUser.setNewsid(news.getNewsid());
            newsAndeUser.setNewsstatus(news.getNewsstatus());
            newsAndeUser.setNewstime(news.getNewstime());
            newsAndeUser.setNewsphoto(news.getNewsphoto());
            newsAndeUser.setNewsrelay(news.getNewsrelay());
            newsAndeUser.setNewstext(news.getNewstext());
            newsAndeUser.setNewscomment(news.getNewscomment());
            newsAndeUser.setNewslike(news.getNewslike());
            newsAndeUser.setCommentList(commentMapper.selectByNewsId(news.getNewsid()));
            newsAndeUsers.add(newsAndeUser);
        }
        return ResultVO.createBySuccess("获得原创资讯列表成功", newsAndeUsers);
    }

    @Override
    public ResultVO<List<RelayVO>> getRelay(String username) {
        List<Relay> relayList = relayMapper.getRelayByUser(username);
        if (relayList == null || relayList.size() == 0) {
            return ResultVO.createBySuccess("该用户暂无转发");
        }
        List<RelayVO> relayVOList = new ArrayList<>();
        for (Relay relay : relayList) {
            RelayVO relayVO = new RelayVO();
            relayVO.setRelaytime(relay.getRelaytime());
            relayVO.setRelaystatus(relay.getRelaystatus());
            relayVO.setRelayid(relay.getRelayid());
            relayVO.setRelaytext(relay.getRelaytext());
            relayVO.setUsername(username);
            relayVO.setNews(newsMapper.selectByPrimaryKey(relay.getNewsid()));
            relayVOList.add(relayVO);
        }
        return ResultVO.createBySuccess("获得转发消息列表成功", relayVOList);
    }
}
