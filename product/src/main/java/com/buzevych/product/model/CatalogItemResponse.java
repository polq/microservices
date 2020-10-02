package com.buzevych.product.model;

import lombok.Data;

@Data
public class CatalogItemResponse {

    private String id;
    private String skuNumber;
    private String name;
    private String description;
    private Double listPrice;
    private Double price;
    private String category;
    private String categoryTree;
    private Double averageProductRating;
    private String productUrl;
    private String productImageUrl;
    private String brand;
    private Integer viewsNumber;
    private String reviews;

}
