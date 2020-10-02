package com.buzevych.product.service;

import com.buzevych.product.model.CatalogItemResponse;
import com.buzevych.product.model.InventoryItemResponse;

import java.util.List;
import java.util.Optional;

public interface ApiService {

    Optional<CatalogItemResponse> getCatalogItem(String id);

    List<CatalogItemResponse> getCatalogItemsBySku(String sku);

    Optional<InventoryItemResponse> getInventoryItem(String id);
}
