package com.fidofi.service.impl;

import com.fidofi.entity.Relay;
import com.fidofi.service.RelayService;
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
public class RelayServiceImplTest {
    @Autowired
    private RelayService relayService;

    @Test
    public void create() throws Exception {
           Relay relay=new Relay();
           relay.setNewsid(5);
           relay.setRelaytext("转发测试！！");
           relay.setUsername("测试");
           relayService.create(relay);
    }

    @Test
    public void delete() throws Exception {
          relayService.delete(2);
    }

    @Test
    public void getUnRead() throws Exception {
            List<Relay> relayList=relayService.getUnRead("fidofi").getData();
            for(Relay r:relayList){
                System.out.println(r);
            }
    }

}