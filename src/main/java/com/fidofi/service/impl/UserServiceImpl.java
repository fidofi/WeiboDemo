package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.UserFreezeMapper;
import com.fidofi.dao.UserMapper;
import com.fidofi.entity.User;
import com.fidofi.service.UserService;
import com.fidofi.utils.PasswordUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fido on 2018/1/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserFreezeMapper freezeMapper;

    @Override
    public ResultVO<User> login(String username, String userpassword) {
        ResultVO<User> resultVO;
        User user = userMapper.selectByPrimaryKey(username);
        if (user == null) {
            return ResultVO.createByError("用户名或密码错误！");
        }
        if (freezeMapper.selectByUsername(user.getUsername()) != null) {
            return ResultVO.createByError("用户被冻结，暂时无法登录");
        }
        String salt = user.getUsersalt();
        userpassword = userpassword + salt;
        //加密后再匹配
        String password = PasswordUtils.MD5(userpassword);
        User findUser = userMapper.login(username, password);
        if (findUser == null) {
            resultVO = ResultVO.createBySuccess(null);
        } else {
            resultVO = ResultVO.createBySuccess("登录成功", findUser);
        }
        return resultVO;
    }

    @Override
    public ResultVO register(User user) {
        if (StringUtils.isBlank(user.getUsername())) {
            return ResultVO.createByError("用户名不能为空");
        }
        if (StringUtils.isBlank(user.getUserpassword())) {
            return ResultVO.createByError("密码不能为空");
        }
        if (user.getUsersex() == null) {
            return ResultVO.createByError("性别不能为空");
        }
        User findUser = userMapper.selectByPrimaryKey(user.getUsername());
        if (findUser != null) {
            return ResultVO.createByError("用户名已经被注册!");
        }
        String salt = PasswordUtils.getSalt();//获取密码盐值
        String password = PasswordUtils.MD5(user.getUserpassword() + salt);
        //盐值和加密后的密码
        user.setUsersalt(salt);
        user.setUserpassword(password);
        userMapper.insert(user);
        return ResultVO.createBySuccess("注册成功！");
    }

    @Override
    public ResultVO<User> findUserByName(String username) {
        User user = userMapper.selectByPrimaryKey(username);
        if (user == null) {
            return ResultVO.createByError("未找到该用户");
        }
        return ResultVO.createBySuccess("查找成功", user);
    }

    @Override
    public ResultVO<User> update(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i == 0) {
            return ResultVO.createByError("更新失败");
        }
        User newUser = userMapper.selectByPrimaryKey(user.getUsername());
        return ResultVO.createBySuccess("更新成功", newUser);
    }
}
