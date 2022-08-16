package com.kazim.eshop.product.model.product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

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
    private String sellerId;
    private String features;
    private int available;
    private boolean freeDelivery;
    private String deliveryIn;
    private String categoryId;
    private List<String> images;
    private HashMap<MoneyTypes, BigDecimal> price;
}
