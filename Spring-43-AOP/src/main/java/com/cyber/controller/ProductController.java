package com.cyber.controller;

import com.cyber.entity.Product;
import com.cyber.entity.ResponseWrapper;
import com.cyber.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    //HttpHeaders
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){

        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version","TicketNG.v1");
        responseHttpHeaders.set("Operation","Get List");

        return ResponseEntity
                .ok() //status=200
                .headers(responseHttpHeaders)
                .body(productService.getProducts());
    }

    //ResponseEntity.header()
    @PostMapping
    public ResponseEntity<List<Product>> createProducts(@RequestBody Product product){

        List<Product> set = productService.createProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version","TicketNG.v1")
                .header("Operation","Create")
                .body(set);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") Long id){

        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version","TicketNG.v1");
        responseHttpHeaders.set("Operation","Delete List");

        List<Product> list = productService.delete(id);

        return new ResponseEntity<>(list,responseHttpHeaders,HttpStatus.OK);
    }

    //MultiValueMap
    @PutMapping(value = "/{id}")
    public ResponseEntity<List<Product>> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){

        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("Version","TicketNG.v1");
        map.add("Operation","Update");

        List<Product> list = productService.updateProduct(id,product);

        return new ResponseEntity<>(list,map,HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts(){
        return ResponseEntity
                .ok(new ResponseWrapper("products successfully retrieved",productService.getProducts()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct2(@PathVariable("id") Long id){
        return ResponseEntity
                .ok(new ResponseWrapper("products successfully deleted"));
    }

    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct3(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper("products successfully deleted !!"));
    }
}
