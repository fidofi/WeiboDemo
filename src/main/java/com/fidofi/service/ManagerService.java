package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.Manager;
import com.fidofi.entity.User;

import java.util.List;

/**
 * Created by fido on 2018/1/7.
 */
public interface ManagerService {

    public ResultVO<Manager> login(String rootname, String rootpassword);

    public ResultVO<Manager> findManagerByName(String rootname);

    public ResultVO<Manager> update(Manager manager);

    public ResultVO create(Manager manager);

    public ResultVO<List<Manager>> getManagers();

}
