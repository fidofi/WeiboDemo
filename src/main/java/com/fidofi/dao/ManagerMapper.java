package com.fidofi.dao;

import com.fidofi.entity.Manager;
import com.fidofi.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {
    int deleteByPrimaryKey(String rootname);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(String rootname);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    Manager login(@Param("rootname") String username, @Param("rootpassword") String rootpassword);

    List<Manager> getAllManagers();
}