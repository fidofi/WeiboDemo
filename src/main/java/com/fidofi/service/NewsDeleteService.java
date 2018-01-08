package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.NewsDeletion;
import com.fidofi.entity.UserFreeze;

import java.util.List;

/**
 * Created by fido on 2018/1/7.
 */
public interface NewsDeleteService {
    public ResultVO deleteNews(NewsDeletion newsDeletion);

}
