package com.shang.service;

import com.shang.domain.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询所有的角色
     * @return
     * @throws Exception
     */
    public List<Role>findAllRole(Integer page, Integer pageSize) throws Exception;

    /**
     * 添加角色
     * @param role
     */
    public int saveRole(Role role)throws Exception;

    /**
     * 根据角色id查询角色详情信息
     * @param roleid
     * @return
     */
    Role findRoleByRoleId(String roleid);

    /**
     * 根据用户的id查询当前用户,所没有的角色信息
     * @param userid
     * @return
     */
    public List<Role> findOtherRole(String userid) throws Exception;
}
