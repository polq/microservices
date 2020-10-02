package org.buzevych.inventory.service;

import lombok.RequiredArgsConstructor;
import org.buzevych.inventory.repository.InventoryRepository;
import org.buzevych.inventory.repository.entity.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<InventoryItem> findAllByIds(List<String> ids) {
        return inventoryRepository.findAllByIds(ids);
    }

    @Override
    public InventoryItem findById(String id) {
        Optional<InventoryItem> item = inventoryRepository.findById(id);
        return item.orElseThrow();
    }
}
