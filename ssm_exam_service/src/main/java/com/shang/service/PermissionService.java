package com.shang.service;

import com.shang.domain.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 查询所有的权限
     * @return
     */
    public List<Permission> findAllPermission(Integer page,Integer pageSize) throws Exception;

    /**
     * 添加权限
     * @param permission
     */
    public int savePermission(Permission permission) throws Exception;

    /**
     * 根据角色的id查询当前角色没有的权限
     * @param roleid
     * @return
     * @throws Exception
     */
    public List<Permission> findOtherPermissionByRoleId(String roleid) throws Exception;
}
