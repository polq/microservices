package org.buzevych.inventory.controller;

import org.buzevych.inventory.repository.entity.InventoryItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/inventory")
public interface InventoryController {

    @GetMapping
    ResponseEntity<List<InventoryItem>> findAllByIds(@RequestParam(name = "ids") List<String> ids);

    @GetMapping("/{id}")
    ResponseEntity<InventoryItem> findById(@PathVariable(name = "id") String id);

}
