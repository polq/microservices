package org.buzevych.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.buzevych.inventory.repository.entity.InventoryItem;
import org.buzevych.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InventoryControllerImpl implements InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Override
    public ResponseEntity<List<InventoryItem>> findAllByIds(List<String> ids) {
        return ResponseEntity.ok(inventoryService.findAllByIds(ids));
    }

    @Override
    public ResponseEntity<InventoryItem> findById(String id) {
        //TimeUnit.SECONDS.sleep(2);

        return ResponseEntity.ok(inventoryService.findById(id));
    }
}
