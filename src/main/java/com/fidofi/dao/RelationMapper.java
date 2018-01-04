package com.fidofi.dao;

import com.fidofi.entity.Relation;
import com.fidofi.entity.RelationKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationMapper {
    int deleteByPrimaryKey(RelationKey key);

    int insert(Relation record);

    int insertSelective(Relation record);

    Relation selectByPrimaryKey(RelationKey key);

    int updateByPrimaryKeySelective(Relation record);

    int updateByPrimaryKey(Relation record);

    List<Relation> getFans(String username);

    List<Relation> getFollowers(String username);

    int follow(RelationKey key);

    int unfollow(RelationKey key);

    Relation findRelationByTwo(RelationKey key);
    
}