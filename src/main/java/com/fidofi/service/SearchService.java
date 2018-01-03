package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by fido on 2018/1/3.
 * 搜索
 */
public interface SearchService {

    /**
     * 根据输入的关键词搜索
     * 返回模糊查询得到的用户列表和资讯列表
     * @param search
     * @param username
     * @return
     */
    public ResultVO<Map<String, Object>> search(String search,String username);
}
