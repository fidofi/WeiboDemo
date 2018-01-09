package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.NewsMapper;
import com.fidofi.dao.RelayMapper;
import com.fidofi.dao.UserMapper;
import com.fidofi.entity.Comment;
import com.fidofi.entity.News;
import com.fidofi.entity.Relay;
import com.fidofi.service.RelayService;
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
public class RelayServiceImpl implements RelayService {
    @Autowired
    private RelayMapper relayMapper;
    @Autowired
    private NewsMapper newsMapper;


    @Override
    public ResultVO create(Relay relay) {
        int i = relayMapper.insert(relay);
        int j = newsMapper.createRelay(relay.getNewsid());
        if (i > 0 && j > 0) {
            return ResultVO.createBySuccess("转发成功");
        } else {
            return ResultVO.createByError("转发失败");
        }
    }

    @Override
    public ResultVO delete(Integer relayid) {
        Relay relay = relayMapper.selectByPrimaryKey(relayid);
        int i = relayMapper.deleteByPrimaryKey(relayid);
        int j = newsMapper.deleteRelay(relay.getNewsid());
        if (i > 0) {
            return ResultVO.createBySuccess("删除转发成功");
        } else {
            return ResultVO.createByError("删除转发失败");
        }
    }

    @Override
    public ResultVO<List<Relay>> getUnRead(String userName) {
        List<Relay> relayList = new ArrayList<>();
        List<News> newsList = newsMapper.selectByUser(userName);
        if (newsList == null || newsList.size() == 0) {
            return ResultVO.createBySuccess("此用户还没用发过资讯");
        }
        //遍历
        for (News news : newsList) {
            List<Relay> currentRelayList = relayMapper.getUnRead(news.getNewsid());
            if (currentRelayList == null && currentRelayList.size() == 0) {
                continue;
            } else {
                relayList.addAll(currentRelayList);
            }
        }
        return ResultVO.createBySuccess("获取未读转发消息列表", relayList);
    }

    @Override
    public ResultVO doReadRelay(Integer relayid) {
        int j = relayMapper.changeStatus(relayid);
        if (j == 0) {
            return ResultVO.createByError("操作失败");
        } else return ResultVO.createBySuccess("操作成功");
    }
}

