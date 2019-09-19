package com.shang.service;


import com.shang.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    public List<UserInfo> findAllUser(Integer page, Integer pageSize)throws Exception;

    /**
     * 添加用户
     * @param userInfo
     * @return
     * @throws Exception
     */
    public int saveUserInfo(UserInfo userInfo)throws Exception;

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public UserInfo findUserById(String id)throws  Exception;

}
