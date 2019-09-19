package com.shang.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionDao {
    /**
     * 给角色添加权限
     * @param roleid
     * @param permissionid
     * @throws Exception
     */
    @Insert("insert into role_permission values(#{permissionid},#{roleid})")
    public void addPermissionToRole(@Param("roleid")String roleid,
                                    @Param("permissionid")String permissionid) throws Exception;
}
