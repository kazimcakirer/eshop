package com.kazim.eshop.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSellerReponse {
        
    private String id;
    private String name;
}
