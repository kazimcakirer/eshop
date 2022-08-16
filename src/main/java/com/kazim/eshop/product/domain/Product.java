package com.kazim.eshop.product.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "product")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of="id")
public class Product {
    
    @Id
    private String id;
    private String name;
    private String code;
    private String description;
    private String companyId;
    private String features;
    private String categoryId;
    private HashMap<MoneyTypes, BigDecimal> price;
    private List<ProductImage> productImage;
    private Boolean active;
}
