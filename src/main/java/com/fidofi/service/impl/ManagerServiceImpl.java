package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.ManagerMapper;
import com.fidofi.entity.Manager;
import com.fidofi.entity.User;
import com.fidofi.service.ManagerService;
import com.fidofi.utils.PasswordUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fido on 2018/1/7.
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;


    @Override
    public ResultVO<Manager> login(String rootname, String rootpassword) {
        ResultVO<Manager> resultVO;
        Manager manager = managerMapper.selectByPrimaryKey(rootname);
        if (manager == null) {
            return ResultVO.createByError("用户名或密码错误！");
        }
        String salt = manager.getRootsalt();
        rootpassword = rootpassword + salt;
        //加密后再匹配
        String password = PasswordUtils.MD5(rootpassword);
        //查询
        Manager findManager = managerMapper.login(rootname, password);
        if (findManager == null) {
            resultVO = ResultVO.createBySuccess(null);
        } else {
            resultVO = ResultVO.createBySuccess("登录成功", findManager);
        }
        return resultVO;
    }

    @Override
    public ResultVO<Manager> findManagerByName(String rootname) {
        Manager manager = managerMapper.selectByPrimaryKey(rootname);
        if (manager == null) {
            return ResultVO.createByError("未找到该管理员");
        }
        return ResultVO.createBySuccess("查找成功", manager);
    }

    @Override
    public ResultVO<Manager> update(Manager manager) {
        Manager manager1 = managerMapper.selectByPrimaryKey(manager.getRootname());
        if (manager1 != null) {
            return ResultVO.createByError("用户名已存在");
        }
        int i = managerMapper.updateByPrimaryKeySelective(manager);
        if (i == 0) {
            return ResultVO.createByError("更新失败");
        }
        Manager manager2 = managerMapper.selectByPrimaryKey(manager.getRootname());
        return ResultVO.createBySuccess("更新成功", manager2);
    }

    @Override
    public ResultVO create(Manager manager) {
        if (StringUtils.isBlank(manager.getRootname())) {
            return ResultVO.createByError("用户名不能为空");
        }
        if (StringUtils.isBlank(manager.getRootpassword())) {
            return ResultVO.createByError("密码不能为空");
        }
        if (manager.getRootpower() == null) {
            return ResultVO.createByError("权限不能为空");
        }
        Manager manager1=managerMapper.selectByPrimaryKey(manager.getRootname());
        if (manager1 != null) {
            return ResultVO.createByError("用户名已存在!");
        }
        String salt = PasswordUtils.getSalt();//获取密码盐值
        String password = PasswordUtils.MD5(manager.getRootpassword() + salt);
        //盐值和加密后的密码
        manager.setRootsalt(salt);
        manager.setRootpassword(password);
        managerMapper.insert(manager);
        return ResultVO.createBySuccess("新增管理员成功！");
    }

    @Override
    public ResultVO<List<Manager>> getManagers() {
        List<Manager> list = managerMapper.getAllManagers();
        if (list == null) {
            return ResultVO.createBySuccess("暂无管理员");
        }
        return ResultVO.createBySuccess("查找管理员列表", list);
    }
}
