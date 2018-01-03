package com.fidofi.dao;

import com.fidofi.entity.UserFreeze;
import com.fidofi.entity.UserFreezeKey;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFreezeMapper {
    int deleteByPrimaryKey(UserFreezeKey key);

    int insert(UserFreeze record);

    int insertSelective(UserFreeze record);

    UserFreeze selectByPrimaryKey(UserFreezeKey key);

    int updateByPrimaryKeySelective(UserFreeze record);

    int updateByPrimaryKey(UserFreeze record);

    UserFreeze selectByUsername(String username);

}