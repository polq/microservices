package com.buzevych.catalog.service;

import com.buzevych.catalog.repository.entity.CatalogItem;
import com.buzevych.catalog.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public CatalogItem getCatalogItem(String id) {
        return catalogRepository.getOne(id);
    }

    @Override
    public List<CatalogItem> getCatalogItemsBySku(String skuNumber) {
        return catalogRepository.findProductsBySkuNumber(skuNumber);
    }
}
