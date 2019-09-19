package com.shang.service;

import java.util.List;

public interface UserInfoRoleService {
    /**
     * 将用户和角色id添加到关联表中
     * @param userid
     * @param roleids
     * @return
     * @throws Exception
     */
   public void addRoleToUser (String userid , List<String>roleids) throws Exception;
}
