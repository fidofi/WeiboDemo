package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by fido on 2018/1/2.
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param username     用户名
     * @param userpassword 密码
     * @return
     */
    public ResultVO<User> login(String username, String userpassword);

    /**
     * 注册
     *
     * @param user 用户信息
     * @return
     */
    public ResultVO register(User user);

    /**
     * 根据名字查询用户
     * @param username
     * @return
     */
    public ResultVO<User> findUserByName(String username);

    /**
     * 更新用户
     * 返回更新后的用户
     * @param user
     * @return
     */
    public ResultVO<User> update(User user);


}