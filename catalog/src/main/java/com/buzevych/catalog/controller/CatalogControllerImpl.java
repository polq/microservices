package com.buzevych.catalog.controller;

import com.buzevych.catalog.repository.entity.CatalogItem;
import com.buzevych.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatalogControllerImpl implements CatalogController {

    @Autowired
    private CatalogService catalogService;

    @Override
    public ResponseEntity<List<CatalogItem>> getCatalogItemsBySku(String skuNumber) {
        return ResponseEntity.ok(catalogService.getCatalogItemsBySku(skuNumber));
    }

    @Override
    public ResponseEntity<CatalogItem> getCatalogItem(String id) {
        return ResponseEntity.ok(catalogService.getCatalogItem(id));
    }
}
