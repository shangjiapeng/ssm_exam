package com.shang.service.impl;

import com.github.pagehelper.PageHelper;
import com.shang.dao.RoleDao;
import com.shang.domain.Role;
import com.shang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    /**
     * 查询所有的角色
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAllRole(Integer page, Integer pageSize) throws Exception {
        //引入分页插件
        PageHelper.startPage(page,pageSize);
        return roleDao.findAllRole();
    }

    /**
     * 添加角色
     *
     * @param role
     */
    @Override
    public int saveRole(Role role) {
       return roleDao.saveRole(role);
    }

    /**
     * 根据角色id查询角色详情信息
     *
     * @param roleid
     * @return
     */
    @Override
    public Role findRoleByRoleId(String roleid) {
        return roleDao.findRoleByRoleId(roleid);

    }

    /**
     * 根据用户的id查询当前用户,所没有的角色信息
     *
     * @param userid
     * @return
     */
    @Override
    public List<Role> findOtherRole(String userid) throws Exception {
        return roleDao.findOtherRole(userid);
    }
}
