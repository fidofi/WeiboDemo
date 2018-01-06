package com.fidofi.service.impl;

import com.fidofi.VO.RelayVO;
import com.fidofi.VO.ResultVO;
import com.fidofi.entity.News;
import com.fidofi.service.IndexService;
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
public class IndexServiceImplTest {

    @Autowired
    private IndexService indexService;

//    @Test
//    public void getNewsByFollow() throws Exception {
//         ResultVO<List<News>> resultVO=indexService.getNewsByFollow("fidofi");
//         for(News news:resultVO.getData()){
//             System.out.println(news);
//         }
//    }

    @Test
    public void getRelayByRelay() throws Exception {
        ResultVO<List<RelayVO>> resultVO=indexService.getRelayByUser("fidofi");
        for(RelayVO relayVO:resultVO.getData()){
            System.out.println(relayVO);
        }
    }

}