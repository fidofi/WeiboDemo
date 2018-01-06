package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.Relation;
import com.fidofi.entity.Relay;

import javax.xml.transform.Result;
import java.util.List;

/**
 * Created by fido on 2018/1/5.
 */
public interface RelayService {

    /**
     * 新增转发消息
     *
     * @param relay
     * @return
     */
    public ResultVO create(Relay relay);

    /**
     * 删除转发消息
     *
     * @param relayid
     * @return
     */
    public ResultVO delete(Integer relayid);

    /**
     * 找出用户的未读转发消息通知
     * @param userName
     * @return
     */
    public ResultVO<List<Relay>> getUnRead(String userName);

}
