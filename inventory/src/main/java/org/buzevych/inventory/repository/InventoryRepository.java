package org.buzevych.inventory.repository;

import org.buzevych.inventory.repository.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, String> {

    @Query("select items from inventory_items items " +
            "where items.id in :ids")
    List<InventoryItem> findAllByIds(@Param("ids") List<String> ids);
}
