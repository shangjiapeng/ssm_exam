package com.shang.dao;

import com.shang.domain.Traveller;

import java.util.List;

/**
 * 旅客操作类
 */
public interface TravellerDao {
    /**
     * 根据订单编号查询旅客的信息
     * @param id
     * @return
     */
    public List<Traveller>findTravellerByOrderId(String id) throws Exception;
}
