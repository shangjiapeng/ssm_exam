package com.shang.service.impl;

import com.github.pagehelper.PageHelper;
import com.shang.dao.ProductDao;
import com.shang.domain.Product;
import com.shang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    /**
     * 查询所有产品
     * @return
     */
/*
    @Override
    public List<Product> findAllProduct() {
        return productDao.findAllProduct();
    }
*/
    /**
     * 分页查询所有的订单
     * @param page 当前的页码
     * @param pageSize 没页显示几条数据
     * @return
     */
    public List<Product> findAllProduct(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return productDao.findAllProduct();
    }



    /*
     * 添加商品
     * @param product
     * @return
     */
    @Override
    public int saveProduct(Product product) throws Exception {
        return productDao.saveProduct(product);
    }
}
