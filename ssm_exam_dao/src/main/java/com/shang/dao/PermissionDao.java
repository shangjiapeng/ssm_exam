package com.shang.dao;

import com.shang.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源权限管理类
 */
@Repository
public interface PermissionDao {
    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    @Select("select * from permission")
    public List<Permission> findAllPermission() throws Exception;

    /**
     * 保存权限
     * @param permission
     */
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    public int savePermission(Permission permission);

    /**
     * 根据角色的id查询权限信息
     * @param roleid
     * @return
     * @throws Exception
     */
    @Select("select p.* from permission p left join role_permission rp on p.id=rp.permissionid where rp.roleid=#{roleId}")
    public List<Permission> findPermissionByRoleId(String roleid) throws Exception;

    /**
     * 根据角色的id查询当前角色没有的权限
     * @param roleid
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findOtherPermissionByRoleId(String roleid) throws Exception;

}
