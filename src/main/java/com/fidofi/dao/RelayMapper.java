package com.fidofi.dao;

import com.fidofi.entity.Relay;
import org.springframework.stereotype.Repository;

@Repository
public interface RelayMapper {
    int deleteByPrimaryKey(Integer relayid);

    int insert(Relay record);

    int insertSelective(Relay record);

    Relay selectByPrimaryKey(Integer relayid);

    int updateByPrimaryKeySelective(Relay record);

    int updateByPrimaryKey(Relay record);
}