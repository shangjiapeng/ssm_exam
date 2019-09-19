package com.shang.service.impl;

import com.github.pagehelper.PageHelper;
import com.shang.dao.OrdersDao;
import com.shang.domain.Orders;
import com.shang.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    /**
     * 查询所有的订单
     * @return
     */
/*
    @Override
    public List<Orders> findAllOrders() {
        return ordersDao.findAllOrders();
    }
*/

    /**
     * 分页查询所有的订单
     * @param page 当前的页码
     * @param pageSize 没页显示几条数据
     * @return
     */
    @Override
    public List<Orders> findAllOrders(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAllOrders();
    }

    /**
     * 根据订单编号查询订单的信息
     * @param id
     * @return
     */
    @Override
    public Orders findOrdersById(String id) throws Exception {
        return ordersDao.findOrdersById(id);
    }
}
