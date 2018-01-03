package com.fidofi.service.impl;

import com.fidofi.VO.NewsAndeUser;
import com.fidofi.VO.ResultVO;
import com.fidofi.VO.SearchUser;
import com.fidofi.dao.NewsMapper;
import com.fidofi.dao.RelationMapper;
import com.fidofi.dao.UserFreezeMapper;
import com.fidofi.dao.UserMapper;
import com.fidofi.entity.News;
import com.fidofi.entity.Relation;
import com.fidofi.entity.RelationKey;
import com.fidofi.entity.User;
import com.fidofi.service.SearchService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.swing.StringUIClientPropertyKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fido on 2018/1/3.
 * 搜索
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private RelationMapper relationMapper;


    @Override
    public ResultVO<Map<String, Object>> search(String search, String username) {
        if (StringUtils.isBlank(search)) {
            return ResultVO.createByError("搜索词为空");
        }
        Map<String, Object> map = new HashMap<>();
        List<User> userList = userMapper.selectByUsername(search);
        if (userList != null && userList.size() > 0) {
            List<SearchUser> searchUsers = new ArrayList<>();
            for (User user : userList) {
                RelationKey relationKey = new RelationKey(username, user.getUsername());
                Relation relation = relationMapper.selectByPrimaryKey(relationKey);
                if (relation == null) {
                    SearchUser searchUser = new SearchUser(user, false);
                    searchUsers.add(searchUser);
                } else if (relation.getRelationstatus() == true) {
                    SearchUser searchUser = new SearchUser(user, true);
                    searchUsers.add(searchUser);
                } else {
                    SearchUser searchUser = new SearchUser(user, false);
                    searchUsers.add(searchUser);
                }
            }
            map.put("userList", searchUsers);
        }
        List<News> newsList = newsMapper.selectByNewstext(search);
        List<NewsAndeUser> newsAndeUsers;
        if (newsList != null && newsList.size() > 0) {
            newsAndeUsers = new ArrayList<>();
            for (News news : newsList) {
                NewsAndeUser newsAndeUser = new NewsAndeUser();
                BeanUtils.copyProperties(news, newsAndeUser);
                User user = userMapper.selectByPrimaryKey(news.getUsername());
                newsAndeUser.setUser(user);
                newsAndeUsers.add(newsAndeUser);
            }
            map.put("newsList", newsAndeUsers);
        }
        ResultVO<Map<String, Object>> resultVO = ResultVO.createBySuccess("查询成功", map);
        return resultVO;
    }
}
