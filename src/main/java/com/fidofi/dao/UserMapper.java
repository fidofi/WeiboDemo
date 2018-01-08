package com.fidofi.dao;

import com.fidofi.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    List<User> selectByUsername(@Param("username") String username);

    User login(@Param("username") String username, @Param("userpassword") String userpassword);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findUser(String username);

    List<User> getAllUserList();

}