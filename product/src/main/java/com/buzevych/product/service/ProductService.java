package com.buzevych.product.service;

import com.buzevych.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProduct(String id);

    List<Product> getProductsBySku(String skuNumber);
}
