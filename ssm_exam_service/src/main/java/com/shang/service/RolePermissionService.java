package com.shang.service;

import java.util.List;

public interface RolePermissionService {
    /**
     * 给角色添加权限
     * @param roleid
     * @param permissionids
     * @throws Exception
     */
    public void addPermissionToRole(String roleid, List<String> permissionids) throws Exception;
}
