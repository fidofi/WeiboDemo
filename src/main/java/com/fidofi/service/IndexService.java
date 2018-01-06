package com.fidofi.service;

import com.fidofi.VO.NewsAndeUser;
import com.fidofi.VO.RelayVO;
import com.fidofi.VO.ResultVO;
import com.fidofi.entity.News;
import com.fidofi.entity.Relay;

import java.util.List;

/**
 * Created by fido on 2018/1/6.
 * 获取该用户首页应该展示的资讯
 * 用户关注的人和自己的资讯，原创和转发
 */
public interface IndexService {

    public ResultVO<List<NewsAndeUser>> getNewsByFollow(String userName);

    public ResultVO<List<RelayVO>> getRelayByUser(String userName);
}
