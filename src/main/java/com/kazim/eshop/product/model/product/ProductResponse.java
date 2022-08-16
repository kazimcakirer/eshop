package com.kazim.eshop.product.model.product;

import java.math.BigDecimal;

import com.kazim.eshop.product.domain.MoneyTypes;
import com.kazim.eshop.product.model.ProductSellerReponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private String id;
    private String image;
    private String name;
    private String description;
    private ProductSellerReponse seller;
    private String features;
    private int available;
    private boolean freeDelivery;
    private String deliveryIn;
    private BigDecimal price;
    private String categoryId;
    private String moneySymbol;
}
