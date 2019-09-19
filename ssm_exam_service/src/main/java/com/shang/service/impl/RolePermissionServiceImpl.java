package com.shang.service.impl;

import com.shang.dao.RolePermissionDao;
import com.shang.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolePermissionDao rolePermissionDao;

    /**
     * 给角色添加权限
     *
     * @param roleid
     * @param permissionids
     * @throws Exception
     */
    @Override
    public void addPermissionToRole(String roleid, List<String> permissionids) throws Exception {
        for (String permissionid : permissionids) {
            rolePermissionDao.addPermissionToRole(roleid,permissionid);
        }
    }
}
