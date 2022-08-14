package com.kazim.eshop.product.model;

import java.math.BigDecimal;

import com.kazim.eshop.product.domain.MoneyTypes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSaveRequest {
    
    private String id;
    private String image;
    private String name;
    private String description;
    private ProductSellerResponse seller;
    private String features;
    private int available;
    private boolean freeDelivery;
    private String deliveryIn;
    private BigDecimal price;
    private String categoryId;
    private MoneyTypes moneyType;
}
