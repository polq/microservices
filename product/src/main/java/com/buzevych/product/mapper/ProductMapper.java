package com.buzevych.product.mapper;

import com.buzevych.product.model.CatalogItemResponse;
import com.buzevych.product.model.InventoryItemResponse;
import com.buzevych.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", source = "catalog.id")
    Product fromResponses(CatalogItemResponse catalog, InventoryItemResponse inventoryItemResponse);
}
