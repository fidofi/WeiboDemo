package com.fidofi.dao;

import com.fidofi.entity.News;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by fido on 2018/1/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsMapperTest {

    @Autowired
    private NewsMapper newsMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {

    }

    @Test
    public void selectByNewstext() throws Exception {

    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

    @Test
    public void selectByUser() throws Exception {
       List<News> newsList=newsMapper.selectByUser("fidofi");
       for(News news:newsList){
           System.out.println(news);
       }
    }

}