package com.fidofi.dao;

import com.fidofi.entity.Relay;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelayMapper {
    int deleteByPrimaryKey(Integer relayid);

    int insert(Relay record);

    int insertSelective(Relay record);

    Relay selectByPrimaryKey(Integer relayid);

    int updateByPrimaryKeySelective(Relay record);

    int updateByPrimaryKey(Relay record);

    List<Relay> getUnRead(Integer newsId);

    Integer getRelayNum(Integer newsId);

    List<Relay> getRelayByUser(String userName);
}