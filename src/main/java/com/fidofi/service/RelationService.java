package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.Relation;
import com.fidofi.entity.RelationKey;
import com.fidofi.entity.User;

import java.util.List;

/**
 * Created by fido on 2018/1/3.
 * 关注关系处理
 */
public interface RelationService {


    /**
     * 查找这两个用户的关系
     * 表示关系：第一个用户在前，第二个用户在后
     * false：第一个用户没有关注第二个用户
     * true：第一个用户与第二个用户相互关注
     *
     * @param relationKey
     * @return
     */
    public ResultVO<Boolean> getRelationByPrimaryKey(RelationKey relationKey);

    /**
     * 获得指定用户的粉丝
     *
     * @param username
     * @return
     */
    public ResultVO<List<User>> getFans(String username);

    /**
     * 获得指定用户的所关注的列表
     *
     * @param username
     * @return
     */
    public ResultVO<List<User>> getFollowers(String username);

    /**
     * 关注用户
     *
     * @param relationKey
     * @return
     */
    public ResultVO follow(RelationKey relationKey);

    /**
     * 取关用户
     *
     * @param relationKey
     * @return
     */
    public ResultVO unfollow(RelationKey relationKey);

    /**
     * 移除粉丝
     *
     * @param relationKey
     * @return
     */

    public ResultVO unfriend(RelationKey relationKey);

}
