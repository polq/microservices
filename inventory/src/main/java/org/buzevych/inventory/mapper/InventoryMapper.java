package org.buzevych.inventory.mapper;

import model.ProductRow;
import org.buzevych.inventory.repository.entity.InventoryItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "available", expression = "java(new java.util.Random().nextInt(2) == 0)")
    InventoryItem fromProductRow(ProductRow productRow);
}
