package com.shang.service;

import com.shang.domain.Orders;

import java.util.List;

public interface OrdersService {
    /**
     * 查询所有的订单
     * @return
     */
//    public List<Orders>findAllOrders();

    /**
     * 分页查询所有的订单
     * @param page 当前的页码
     * @param pageSize 没呀显示几条数据
     * @return
     */
    public List<Orders> findAllOrders(Integer page ,Integer pageSize) throws Exception;

    /**
     * 根据订单的编号查询订单的信息
     * @param id
     * @return
     */
    public Orders findOrdersById(String id) throws Exception;
}
