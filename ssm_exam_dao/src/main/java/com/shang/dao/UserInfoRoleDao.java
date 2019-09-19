package com.shang.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface UserInfoRoleDao {
    /**
     * 将用户和角色id添加到关联表中
     * @param userid
     * @param roleid
     * @return
     * @throws Exception
     */
    @Insert(" insert into userinfo_role values(#{userid},#{roleid})")
    public void addRoleToUser(@Param("userid")String userid,@Param("roleid")String roleid) throws Exception;
}
