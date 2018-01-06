package com.fidofi.utils;

import com.fidofi.dao.UserMapper;
import com.fidofi.entity.Relation;
import com.fidofi.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2018/1/6.
 */
public class RelationUtils {
    //从关注关系中查找给定用户的给定关系的用户列表
    public static List<User> getUserListFromRelation(List<Relation> relationList, String username, UserMapper userMapper) {
        List<User> userList = new ArrayList<>();
        for (Relation relation : relationList) {
            if (relation.getFirstuser().equals(username)) {
//                User user = userMapper.findUser(relation.getSecondeuser());
                User user=userMapper.selectByPrimaryKey(relation.getSecondeuser());
                if (user != null) {
                    userList.add(user);
                }
            } else {
                User user = userMapper.selectByPrimaryKey(relation.getFirstuser());
                if (user != null) {
                    userList.add(user);
                }
            }
        }
        return userList;
    }
}
