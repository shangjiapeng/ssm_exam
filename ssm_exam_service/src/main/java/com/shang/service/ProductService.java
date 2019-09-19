package com.shang.service;

import com.shang.domain.Orders;
import com.shang.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有产品
     * @return
     */
    //public List<Product> findAllProduct();

    /**
     * 分页查询所有的订单
     * @param page 当前的页码
     * @param pageSize 没页显示几条数据
     * @return
     */
    public List<Product> findAllProduct(Integer page , Integer pageSize) throws Exception;

    /**
     * 添加商品
     * @param product
     * @return
     */
    public int saveProduct(Product product) throws Exception;
}
