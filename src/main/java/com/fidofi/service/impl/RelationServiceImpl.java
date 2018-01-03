package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.RelationMapper;
import com.fidofi.entity.Relation;
import com.fidofi.entity.RelationKey;
import com.fidofi.entity.User;
import com.fidofi.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fido on 2018/1/3.
 */
@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private RelationMapper relationMapper;

    @Override
    public ResultVO<Relation> getRelationByPrimaryKey(RelationKey relationKey) {
        Relation relation = relationMapper.selectByPrimaryKey(relationKey);
        if (relation == null) {
            return ResultVO.createByError("尚未关注！");
        } else {
            return ResultVO.createBySuccess("查找关系成功", relation);
        }
    }

    @Override
    public ResultVO<List<User>> getFans(String username) {

        return null;
    }

    @Override
    public ResultVO<List<User>> getFollowers(String username) {
        return null;
    }

    @Override
    public ResultVO<Relation> follow(RelationKey relationKey) {
        return null;
    }

    @Override
    public ResultVO<Relation> unfollow(RelationKey relationKey) {
        return null;
    }

    @Override
    public ResultVO<Relation> unfriend(RelationKey relationKey) {
        return null;
    }
}
