package com.shang.service.impl;

import com.github.pagehelper.PageHelper;
import com.shang.dao.PermissionDao;
import com.shang.domain.Permission;
import com.shang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAllPermission(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return permissionDao.findAllPermission();
    }

    @Override
    public int savePermission(Permission permission) throws Exception {
       return permissionDao.savePermission(permission);
    }

    /**
     * 根据角色的id查询当前角色没有的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findOtherPermissionByRoleId(String roleId) throws Exception {
        return permissionDao.findOtherPermissionByRoleId(roleId);
    }
}
