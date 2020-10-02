package com.buzevych.catalog.service;

import com.buzevych.catalog.repository.entity.CatalogItem;

import java.util.List;

public interface CatalogService {

    CatalogItem getCatalogItem(String id);

    List<CatalogItem> getCatalogItemsBySku(String skuNumber);

}
