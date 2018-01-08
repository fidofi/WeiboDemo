package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.UserFreeze;

import java.util.List;

/**
 * Created by fido on 2018/1/7.
 */
public interface UserFreezeService {
    public ResultVO freezeUser(UserFreeze userFreeze);

    public ResultVO unfreezeUser(String username);

    public ResultVO<List<UserFreeze>> getFreezeUsers();

    public ResultVO<UserFreeze> getOneUser(String username);

}
