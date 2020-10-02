package com.buzevych.catalog.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "catalog_items")
public class CatalogItem {

    @Id
    private String id;

    private String skuNumber;

    private String name;

    @Lob
    private String description;

    private Double listPrice;

    private Double price;

    private String category;

    private String categoryTree;

    private Double averageProductRating;

    @Column(length = 500)
    private String productUrl;

    @Column(length = 2200)
    private String productImageUrl;

    private String brand;

    private Integer viewsNumber;

    @Lob
    private String reviews;

}
