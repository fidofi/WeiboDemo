package com.fidofi.service;

import com.fidofi.VO.NewsAndeUser;
import com.fidofi.VO.RelayVO;
import com.fidofi.VO.ResultVO;
import com.fidofi.entity.News;
import com.fidofi.entity.Relay;

import java.util.List;

/**
 * Created by fido on 2018/1/6.
 */
public interface HomePageService {

    /**
     * 获得给定用户发的资讯
     * @param username
     * @return
     */
    public ResultVO<List<NewsAndeUser>> getNews(String username);

    /**
     * 获得给定用户发的转发消息
     * @param username
     * @return
     */
    public ResultVO<List<RelayVO>> getRelay(String username);
}
