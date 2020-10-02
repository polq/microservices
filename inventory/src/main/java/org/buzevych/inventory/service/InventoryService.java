package org.buzevych.inventory.service;

import org.buzevych.inventory.repository.entity.InventoryItem;

import java.util.List;

public interface InventoryService {

    List<InventoryItem> findAllByIds(List<String> ids);

    InventoryItem findById(String id);
}
