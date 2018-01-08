package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.News;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fido on 2018/1/3.
 */

public interface NewsService {

    /**
     * 发布资讯
     * @param news
     * @return
     */
    public ResultVO create(News news);

    /***
     * 获得所有资讯列表
     * @return
     */
    public ResultVO<List<News>> getNewsList();
}
