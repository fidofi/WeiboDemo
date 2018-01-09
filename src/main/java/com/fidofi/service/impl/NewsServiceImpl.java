package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.NewsMapper;
import com.fidofi.entity.News;
import com.fidofi.entity.User;
import com.fidofi.service.NewsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fido on 2018/1/3.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public ResultVO create(News news) {
        if (StringUtils.isBlank(news.getNewstext())) {
            return ResultVO.createByError("请输入文字内容");
        }
        if (news.getNewstext().length() > 150) {
            return ResultVO.createByError("发布的文字不能超过150字");
        }
        newsMapper.insert(news);
        return ResultVO.createBySuccess("发布成功！");
    }

    @Override
    public ResultVO<List<News>> getNewsList() {
        List<News> list = newsMapper.getAllNews();
        if (list == null) {
            return ResultVO.createBySuccess("暂无资讯");
        }
        return ResultVO.createBySuccess("查找资讯列表成功", list);
    }

    @Override
    public ResultVO doLike(Integer newsid) {
        int j=newsMapper.doLike(newsid);
        if(j==0) {
            return ResultVO.createByError("点赞失败");
        }
        return ResultVO.createBySuccess("点赞成功");
    }
}
