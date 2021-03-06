package com.cyber.controller;

import com.cyber.entity.Product;
import com.cyber.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public @ResponseBody Product getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/products") // default get method
    public @ResponseBody List<Product> getProducts(){
        return productService.getProducts();
    }

    @RequestMapping(value = "products", method = RequestMethod.POST)
    public @ResponseBody List<Product> createProducts(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
    public @ResponseBody List<Product> deleteProduct(@PathVariable("id") Long id){
        return productService.delete(id);
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.PUT)
    public @ResponseBody List<Product> updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }
}
