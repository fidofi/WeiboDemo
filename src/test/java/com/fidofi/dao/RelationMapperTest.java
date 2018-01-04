package com.fidofi.dao;

import com.fidofi.WeibodemoApplication;
import com.fidofi.entity.Relation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by fido on 2018/1/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMapperTest {
    @Autowired
    private RelationMapper relationMapper;

    @Test
    public void getFans() throws Exception {
       List<Relation> list=relationMapper.getFans("fidofi");
       for(Relation relation:list){
           System.out.println(relation);
       }
    }

    @Test
    public void getFollowers() throws Exception {
        List<Relation> list=relationMapper.getFollowers("fidofi");
        for(Relation relation:list){
            System.out.println(relation);
        }
    }

    @Test
    public void follow() throws Exception {

    }

    @Test
    public void unfollow() throws Exception {

    }

}