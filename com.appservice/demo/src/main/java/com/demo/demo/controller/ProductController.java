package com.demo.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.commons.utils.ProductUtil;

import beans.Product;

@RestController
public class ProductController {

    @Autowired
    ProductUtil productUtil;

    @GetMapping("/getProducts")
    @ResponseBody
    public List<Product> getProducts(@RequestParam int limit, @RequestParam int start) {
        List<Product> productList = new ArrayList<Product>();

        productList = productUtil.getProducts(limit, start);
        return productList;

    }

    @GetMapping("/getProduct")
    public Product getProduct(@RequestParam int productId) {

        Product product = new Product();
        product = productUtil.getProductbyId(productId);
        return product;

    }
}
