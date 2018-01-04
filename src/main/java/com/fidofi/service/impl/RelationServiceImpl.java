package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.RelationMapper;
import com.fidofi.dao.UserMapper;
import com.fidofi.entity.Relation;
import com.fidofi.entity.RelationKey;
import com.fidofi.entity.User;
import com.fidofi.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2018/1/3.
 */
@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private RelationMapper relationMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVO<Boolean> getRelationByPrimaryKey(RelationKey relationKey) {
        Relation relation = relationMapper.selectByPrimaryKey(relationKey);
        if (relation == null) {
            return ResultVO.createBySuccess("尚未关注", false);
        } else {
            return ResultVO.createBySuccess("查找关系成功", true);
        }
    }

    @Override
    public ResultVO<List<User>> getFans(String username) {
        List<Relation> relationList = relationMapper.getFans(username);
        if (relationList == null) {
            return ResultVO.createBySuccess("尚未有粉丝");
        }
        List<User> userList = this.getUserListFromRelation(relationList, username);
        //找出关系中与条件给出用户名不同的那个即是粉丝

        return ResultVO.createBySuccess("查找粉丝成功", userList);
    }

    @Override
    public ResultVO<List<User>> getFollowers(String username) {
        List<Relation> relationList = relationMapper.getFollowers(username);
        if (relationList == null) {
            return ResultVO.createBySuccess("尚未有关注的人");
        }
        List<User> userList = this.getUserListFromRelation(relationList, username);
        return ResultVO.createBySuccess("查找关注用户", userList);
    }

    @Override
    public ResultVO follow(RelationKey relationKey) {
        RelationKey secondKey = new RelationKey(relationKey.getSecondeuser(), relationKey.getFirstuser());
        if (relationMapper.selectByPrimaryKey(relationKey) != null) {
            return ResultVO.createBySuccess("早已关注！");
        }
        //另一方也没有关注自己，插入新的记录
        else if (relationMapper.selectByPrimaryKey(secondKey) == null) {
            relationMapper.insert(new Relation(relationKey.getFirstuser(), relationKey.getSecondeuser(), false));
            return ResultVO.createBySuccess("关注成功");
        }
        //原先另一方已关注自己，需改成互粉状态
        else {
            Relation relation = new Relation(relationKey.getSecondeuser(), relationKey.getFirstuser(), true);
            relationMapper.follow(secondKey);
            return ResultVO.createBySuccess("关注成功");
        }
    }

    @Override
    public ResultVO unfollow(RelationKey relationKey) {
        Relation relation = relationMapper.findRelationByTwo(relationKey);
        //根本不存在这两个人的关系
        if (relation == null) {
            return ResultVO.createBySuccess("该对用户没有关系");
        } else if (relation.getFirstuser().equals(relationKey.getFirstuser())) {
            //表明单方面关注，直接删掉就好
            if (relation.getRelationstatus() == false) {
                relationMapper.deleteByPrimaryKey(relationKey);
                return ResultVO.createBySuccess("取关成功");
            }
            //表明双方关注，则需要先删除该记录，再插入一条单方面关注的记录
            else {
                relationMapper.deleteByPrimaryKey(relationKey);
                Relation newRelation = new Relation(relationKey.getSecondeuser(), relationKey.getFirstuser(), false);
                relationMapper.insert(newRelation);
                return ResultVO.createBySuccess("取关成功");
            }
        }
//       if (relation.getSecondeuser().equals(relationKey.getFirstuser()))
        else {
            //标明对方单方面关注自己，但自己并没有关注对方
            if (relation.getRelationstatus() == false) {
                return ResultVO.createBySuccess("此对用户没有关系");
            }
            //标明自己也关注对方，修改互粉状态为false，只让对方关注自己
            else {
                relationMapper.unfollow(relationKey);
                return ResultVO.createBySuccess("取关成功");
            }
        }
    }

    @Override
    public ResultVO unfriend(RelationKey relationKey) {
        Relation relation = relationMapper.findRelationByTwo(relationKey);
        //根本不存在这两个人的关系
        if (relation == null) {
            return ResultVO.createBySuccess("该对用户没有关系");
        } else if (relation.getFirstuser().equals(relationKey.getFirstuser())) {
            //表明单方面关注，直接删掉就好
            if (relation.getRelationstatus() == false) {
                return ResultVO.createBySuccess("只是单方面关注，无法移除粉丝");
            }
            //表明双方关注，则需要先删除该记录，再插入一条单方面关注的记录
            else {
                relationMapper.unfollow(relationKey);
                return ResultVO.createBySuccess("移除粉丝成功");
            }
        } else {
            //标明对方单方面关注自己，但自己并没有关注对方
            if (relation.getRelationstatus() == false) {
                relationMapper.deleteByPrimaryKey(relationKey);
                return ResultVO.createBySuccess("移除粉丝成功");
            }
            //标明自己也关注对方
            else {
                relationMapper.deleteByPrimaryKey(relationKey);
                Relation newRelation = new Relation(relationKey.getSecondeuser(), relationKey.getFirstuser(), false);
                return ResultVO.createBySuccess("移除粉丝成功");
            }
        }
    }


    //从关注关系中查找给定用户的给定关系的用户列表
    private List<User> getUserListFromRelation(List<Relation> relationList, String username) {
        List<User> userList = new ArrayList<>();
        for (Relation relation : relationList) {
            if (relation.getFirstuser().equals(username)) {
                User user = userMapper.findUser(relation.getSecondeuser());
                if (user != null) {
                    userList.add(user);
                }
            } else {
                User user = userMapper.findUser(relation.getFirstuser());
                if (user != null) {
                    userList.add(user);
                }
            }
        }
        return userList;
    }
}
