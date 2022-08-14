package com.kazim.eshop.product.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Document(collation = "product_price")
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class ProductPrice {
    private String id;
    private String productId;
    private MoneyTypes moneyTypes;
    private String price;
    
}
