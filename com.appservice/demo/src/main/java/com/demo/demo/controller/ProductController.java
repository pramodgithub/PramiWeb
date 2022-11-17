package com.demo.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.commons.utils.ProductUtil;

import beans.Product;

@RequestMapping("/v1/product")
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

    @RequestMapping(value = "/addProduct", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {

        System.out.println("(Service Side) Creating Product: ");

        return productUtil.addProduct(product);
    }

    @RequestMapping(value = "/deleteProduct/{productId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Product deleteProduct(@PathVariable("productId") int productId) {

        System.out.println("(Service Side) Deleting Product: ");

        return productUtil.deleteProduct(productId);
    }
}
