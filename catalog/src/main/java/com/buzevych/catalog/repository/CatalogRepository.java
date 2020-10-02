package com.buzevych.catalog.repository;

import com.buzevych.catalog.repository.entity.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogItem, String> {

    @Query("select c from catalog_items c where c.skuNumber = :skuNumber")
    List<CatalogItem> findProductsBySkuNumber(@Param("skuNumber") String skuNumber);
}
