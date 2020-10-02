package com.buzevych.catalog.controller;

import com.buzevych.catalog.repository.entity.CatalogItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/catalog")
public interface CatalogController {

    @GetMapping("/{id}")
    ResponseEntity<CatalogItem> getCatalogItem(@PathVariable(value = "id") String id);

    @GetMapping
    ResponseEntity<List<CatalogItem>> getCatalogItemsBySku(@RequestParam(name = "skuNumber") String skuNumber);
}
