package com.shang.dao;


import com.shang.domain.Role;

import java.util.List;

/**
 * 角色操作类
 */
public interface  RoleDao {
    /**
     * 根据用户id查询角色信息
     * @param id
     * @return
     */
    public List<Role>findRoleByUserId(String id) throws Exception;

    /**
     * 查询所有的角色
     * @return
     * @throws Exception
     */
    public List<Role> findAllRole()throws Exception;

    /**
     * 添加角色
     * @param role
     */
    public int saveRole(Role role);


    /**
     * 根据角色id查询角色详情
     * @param roleid
     */
    public Role findRoleByRoleId(String roleid);

    /**
     * 根据用户的id查询当前用户,所没有的角色信息
     * @param userid
     * @return
     */
    public List<Role> findOtherRole(String userid) throws Exception;


}
