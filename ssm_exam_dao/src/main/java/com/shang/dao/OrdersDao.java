package com.shang.dao;

import com.shang.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {
    /**
     * 查询所有的订单
     * @return
     */
    public List<Orders> findAllOrders() throws Exception;

    /**
     * 根据订单id 查询订单信息
     * @param id
     * @return
     */
    public Orders findOrdersById(String id) throws Exception;



}
