package com.fidofi.dao;

import com.fidofi.entity.NewsDeletion;
import com.fidofi.entity.NewsDeletionKey;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDeletionMapper {
    int deleteByPrimaryKey(NewsDeletionKey key);

    int insert(NewsDeletion record);

    int insertSelective(NewsDeletion record);

    NewsDeletion selectByPrimaryKey(NewsDeletionKey key);

    int updateByPrimaryKeySelective(NewsDeletion record);

    int updateByPrimaryKey(NewsDeletion record);
}