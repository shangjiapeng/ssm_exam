package com.shang.controller;

import com.github.pagehelper.PageInfo;
import com.shang.domain.Orders;
import com.shang.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 查询所有的订单信息
     *
     * @param model
     * @return
     */
   /* @RequestMapping("/findAllOrders")
    public String findAllOrders(Model model){
        List<Orders> ordersList = ordersService.findAllOrders();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
        model.addAttribute("ordersList",ordersList);
        return "ordersList";
    }*/

    /**
     * 分页查询订单信息
     * @param model
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAllOrders")
    public String findAllOrders(Model model,
                                @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "3") Integer pageSize) throws Exception {
        List<Orders> ordersList = ordersService.findAllOrders(page, pageSize);
        //使用pageInfo 对象将分页的信息传递到页面
        PageInfo pageInfo = new PageInfo(ordersList);
        model.addAttribute("ordersList", pageInfo);
        return "orders-list-page";
    }

    /**
     * 根据订单的编号查询订单的信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/findOrdersById")
    public String findOrdersById(Model model,@RequestParam(name="id")String id) throws Exception {
        Orders orders = ordersService.findOrdersById(id);
        model.addAttribute("orders",orders);
        return "orders-show";
    }
}
