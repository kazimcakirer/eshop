package com.kazim.eshop.product.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Product {
    
    private String id;
    private String name;
    private String code;
    private String description;
    private String companyId;
    private String features;
    private String categoryId;
    private List<ProductImage> productImage;
    private Boolean active;
}
