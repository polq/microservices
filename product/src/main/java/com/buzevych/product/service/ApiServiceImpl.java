package com.buzevych.product.service;

import com.buzevych.product.model.CatalogItemResponse;
import com.buzevych.product.model.InventoryItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ApiServiceImpl implements ApiService {

    private static final String INVENTORY_API_PATH = "http://inventory/api/inventory";
    private static final String CATALOG_API_PATH = "http://catalog/api/catalog";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Optional<CatalogItemResponse> getCatalogItem(String id) {
        ResponseEntity<CatalogItemResponse> catalogItemResponseResponseEntity =
                restTemplate.getForEntity(CATALOG_API_PATH + "/{id}",
                        CatalogItemResponse.class,
                        id);

        if (catalogItemResponseResponseEntity.getStatusCode() == HttpStatus.OK) {
            return Optional.of(catalogItemResponseResponseEntity.getBody());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<CatalogItemResponse> getCatalogItemsBySku(String sku) {
        ResponseEntity<CatalogItemResponse[]> catalogItemResponseResponseEntity =
                restTemplate.getForEntity(CATALOG_API_PATH + "?skuNumber={sku}",
                        CatalogItemResponse[].class,
                        sku);

        if (catalogItemResponseResponseEntity.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(Objects.requireNonNull(catalogItemResponseResponseEntity.getBody()));
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<InventoryItemResponse> getInventoryItem(String id) {
        ResponseEntity<InventoryItemResponse> itemResponseEntity =
                restTemplate.getForEntity(INVENTORY_API_PATH + "/{id}",
                        InventoryItemResponse.class,
                        id);

        if (itemResponseEntity.getStatusCode() == HttpStatus.OK) {
            return Optional.of(itemResponseEntity.getBody());
        } else {
            return Optional.empty();
        }
    }

}
