package com.buzevych.product.controller;

import com.buzevych.product.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/product")
public interface ProductController {

    @GetMapping("/{id}")
    ResponseEntity<Product> getProduct(@PathVariable(value = "id") String id);

    @GetMapping
    ResponseEntity<List<Product>> getProductsBySku(@RequestParam(name = "skuNumber") String skuNumber);
}
