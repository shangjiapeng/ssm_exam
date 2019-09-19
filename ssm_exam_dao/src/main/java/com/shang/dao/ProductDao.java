package com.shang.dao;

import com.shang.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    /**
     * 查询所有的产品
     * @return
     */
    public List<Product> findAllProduct() throws Exception;

    /**
     * 添加产品
     * @param product
     * @return
     */
    public int saveProduct(Product product) throws Exception;

    /**
     * 根据产品的编号查询产品的信息
     * @param id
     * @return
     */
    public Product findProductById(String id) throws Exception;
}
