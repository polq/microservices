package com.buzevych.catalog.mapper;

import com.buzevych.catalog.repository.entity.CatalogItem;
import model.ProductRow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring")
public interface CatalogItemMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "skuNumber", source = "sku")
    @Mapping(target = "name", source = "nameTitle")
    @Mapping(target = "price", source = "salePrice", qualifiedByName = "toSalePrice")
    @Mapping(target = "viewsNumber", source = "totalNumberReviews", qualifiedByName = "toViewsNumber")
    @Mapping(target = "averageProductRating", source = "averageProductRating", qualifiedByName = "productRatingToDouble")
    CatalogItem fromRow(ProductRow productRow);


    @Named("productRatingToDouble")
    default Double productRatingToDouble(String productRating) {
        if (productRating == null) {
            return 0.0;
        } else {
            return Double.parseDouble(productRating.split(" ")[0]);
        }
    }

    @Named("toViewsNumber")
    default Integer toViewsNumber(String viewsNumber) {
        if (viewsNumber == null) {
            return 0;
        } else {
            try {
                return Integer.parseInt(viewsNumber);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }

    @Named("toSalePrice")
    default Double toSalePrice(String salePrice) {
        if (salePrice == null) {
            return 0.0;
        } else {
            try {
                return Double.parseDouble(salePrice);
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }
    }

}
