package com.shang.dao;

import com.shang.domain.Member;

/**
 * 会员操作类
 */
public interface MemberDao {
    /**
     * 根据会员号,查询会员的信息
     * @param id
     * @return
     */
    public Member findMemberById(String id) throws Exception;
}
