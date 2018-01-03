package com.fidofi.dao;

import com.fidofi.entity.Manager;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerMapper {
    int deleteByPrimaryKey(String rootname);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(String rootname);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}