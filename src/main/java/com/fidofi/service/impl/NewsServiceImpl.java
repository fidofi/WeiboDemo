package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.NewsMapper;
import com.fidofi.entity.News;
import com.fidofi.service.NewsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
