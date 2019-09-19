package com.shang.dao;

import com.shang.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户操作类
 */
@Repository
public interface UserInfoDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public UserInfo findUserInfoByName(String username) throws Exception;
    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    public List<UserInfo> findAllUser()throws Exception;

    /**
     * 添加用户
     * @param userInfo
     * @return
     * @throws Exception
     */
    public int saveUserInfo(UserInfo userInfo)throws Exception;

    /**
     * 根据id查询用户信息以及角色
     * @param id
     * @return
     * @throws Exception
     */
    public UserInfo findUserById(String id)throws  Exception;

}
