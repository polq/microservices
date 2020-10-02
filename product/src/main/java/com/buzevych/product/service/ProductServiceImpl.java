package com.buzevych.product.service;

import com.buzevych.product.mapper.ProductMapper;
import com.buzevych.product.model.CatalogItemResponse;
import com.buzevych.product.model.InventoryItemResponse;
import com.buzevych.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ApiService apiService;
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ApiService apiService, ProductMapper productMapper) {
        this.apiService = apiService;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<Product> getProduct(String id) {
        Optional<CatalogItemResponse> catalogItem = apiService.getCatalogItem(id);
        Optional<InventoryItemResponse> inventoryItemResponse = apiService.getInventoryItem(id);

        if (inventoryItemResponse.isPresent() &&
                catalogItem.isPresent() &&
                inventoryItemResponse.get().getAvailable()) {
            return Optional.of(productMapper.fromResponses(catalogItem.get(), inventoryItemResponse.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Product> getProductsBySku(String skuNumber) {
        List<CatalogItemResponse> catalogItems = apiService.getCatalogItemsBySku(skuNumber);
        Map<CatalogItemResponse, InventoryItemResponse> map = catalogItems.stream()
                .map(catalogItem -> Map.entry(catalogItem, apiService.getInventoryItem(catalogItem.getId())))
                .filter(entry -> entry.getValue().isPresent())
                .filter(entry -> entry.getValue().get().getAvailable())
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get()));

        return map.entrySet().stream()
                .map(entry -> productMapper.fromResponses(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
