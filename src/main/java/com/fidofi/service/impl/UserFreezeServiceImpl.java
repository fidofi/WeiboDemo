package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.UserFreezeMapper;
import com.fidofi.dao.UserMapper;
import com.fidofi.entity.UserFreeze;
import com.fidofi.entity.UserFreezeKey;
import com.fidofi.service.UserFreezeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fido on 2018/1/7.
 */
@Service
public class UserFreezeServiceImpl implements UserFreezeService {

    @Autowired
    private UserFreezeMapper userFreezeMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVO freezeUser(UserFreeze userFreeze) {
        int i = userFreezeMapper.insert(userFreeze);
        if (i == 0) {
            return ResultVO.createByError("冻结失败");
        }
        return ResultVO.createBySuccess("冻结成功");
    }

    @Override
    public ResultVO unfreezeUser(String username) {
        int i = userFreezeMapper.unfreeze(username);
        if (i == 0) {
            return ResultVO.createByError("解冻失败");
        }
        return ResultVO.createBySuccess("解冻成功");
    }

    @Override
    public ResultVO<List<UserFreeze>> getFreezeUsers() {
        return null;
    }

    @Override
    public ResultVO<UserFreeze> getOneUser(String username) {
        UserFreeze userFreeze = userFreezeMapper.selectByUsername(username);
        if (userFreeze == null) {
            return ResultVO.createByError("未找到该用户");
        }
        return ResultVO.createBySuccess("找到该用户", userFreeze);
    }
}
