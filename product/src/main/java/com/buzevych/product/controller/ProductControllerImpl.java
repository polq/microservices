package com.buzevych.product.controller;

import com.buzevych.product.exception.ServiceUnavailableException;
import com.buzevych.product.model.Product;
import com.buzevych.product.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@DefaultProperties(defaultFallback = "fallback",
        commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10")
        })
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    @HystrixCommand
    public ResponseEntity getProduct(String id) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @HystrixCommand
    public ResponseEntity getProductsBySku(String skuNumber) {
        return ResponseEntity.ok(productService.getProductsBySku(skuNumber));
    }

    public ResponseEntity fallback() {
        throw new ServiceUnavailableException();
    }
}
