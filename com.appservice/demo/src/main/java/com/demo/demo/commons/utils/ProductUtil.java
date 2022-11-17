package com.demo.demo.commons.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.jdbc.core.JdbcTemplate;
import com.demo.demo.interfaces.ProductInterface;

import beans.Product;

@Repository
public class ProductUtil implements ProductInterface {

    @Override
    public Product getProductbyId(int prodId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getProducts(int limit, int start) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getProductsByFilter(String[] filters) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product deleteProduct(int productId) {
        // TODO Auto-generated method stub
        return null;
    }

}
