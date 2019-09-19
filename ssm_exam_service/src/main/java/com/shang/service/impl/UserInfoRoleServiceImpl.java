package com.shang.service.impl;

import com.shang.dao.UserInfoRoleDao;
import com.shang.service.UserInfoRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoRoleServiceImpl implements UserInfoRoleService {
    @Autowired
    private UserInfoRoleDao userInfoRoleDao;
    /**
     * 将用户和角色id添加到关联表中
     * 一个用户可以有多个角色
     * @param userid
     * @param roleids
     * @return
     * @throws Exception
     */
    @Override
    public void addRoleToUser(String userid, List<String> roleids) throws Exception {
        for (String roleid : roleids) {
            //调用添加用户角色的方法
            userInfoRoleDao.addRoleToUser(userid, roleid);
        }
    }
}
