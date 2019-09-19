package com.shang.service.impl;

import com.github.pagehelper.PageHelper;
import com.shang.dao.UserInfoDao;
import com.shang.domain.Role;
import com.shang.domain.UserInfo;
import com.shang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录业务类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoDao userInfoDao;
    //注入spring security加密类
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     * 参数为用户名
     * @param username 传递过来的用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userinfo = null;
        User user = null;
        try {
            userinfo = userInfoDao.findUserInfoByName(username);
            //将对userinfo对象转为UserDetails并获得权限
            user = new User(userinfo.getUsername(), /*"{noop}"+*/userinfo.getPassword(),userinfo.getStatus() == 0 ? false : true, true,
                    true, true,getAuthority(userinfo.getRoles()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 获得用户权限
     * @return
     */
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authoritys = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return authoritys;
    }

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAllUser(Integer page, Integer pageSize) throws Exception {
        //引用分页插件
        PageHelper.startPage(page,pageSize);
        return userInfoDao.findAllUser();
    }

    /**
     * 添加用户
     * @param userInfo
     * @return
     * @throws Exception
     */

    @Override
    public int saveUserInfo(UserInfo userInfo) throws Exception {

        //使用spring security 加密密码
        if (bCryptPasswordEncoder!=null) {
            userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        }
        //保存用户信息
        return userInfoDao.saveUserInfo(userInfo);
    }

    /**
     * 根据id查询用户信息,以及角色信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findUserById(String id) throws Exception {
        UserInfo userInfo = userInfoDao.findUserById(id);
        return userInfo;
    }

}
