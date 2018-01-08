package com.fidofi.dao;

import com.fidofi.entity.UserFreeze;
import com.fidofi.entity.UserFreezeKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFreezeMapper {
    int deleteByPrimaryKey(UserFreezeKey key);

    int insert(UserFreeze record);

    int insertSelective(UserFreeze record);

    UserFreeze selectByPrimaryKey(UserFreezeKey key);

    int updateByPrimaryKeySelective(UserFreeze record);

    int updateByPrimaryKey(UserFreeze record);

    UserFreeze selectByUsername(String username);

    List<UserFreeze> getAllFreezeUser();

    int unfreeze(String username);
}