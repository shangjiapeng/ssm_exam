package com.shang.controller;

import com.github.pagehelper.PageInfo;
import com.shang.domain.Product;
import com.shang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     *查询商品
     * @param model
     * @return
     */
    /*@RequestMapping("/findAllProduct")
    public String findAllProduct(Model model){
        List<Product> productList = productService.findAllProduct();
        model.addAttribute("productList",productList);
        return "product-list";
    }*/

    /**
     * 分页查询商品
     * @param model
     * @return
     */
    @RequestMapping("/findAllProduct")
    public String findAllProduct(Model model,
                                 @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                 @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        List<Product> productList = productService.findAllProduct(page,pageSize);
        //使用pageInfo 对象将分页的信息传递到页面
        PageInfo pageInfo = new PageInfo(productList);
        model.addAttribute("productList", pageInfo);
        return "product-list-page";
    }

    /**
     * 保存商品
     * @param product
     * @return
     */
    @RequestMapping("/saveProduct")
    public String saveProduct(Product product) throws Exception {
        int n = productService.saveProduct(product);
        //添加成功之后重定向到查询所有的界面
        if (n>0){
            return "redirect:/product/findAllProduct";
        }
        //如果添加失败,重新返回添加商品的页面
        return "product-add";
    }

}
