package com.kazim.eshop.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    
    private ImageType ImageType;
    private String url;

    public enum ImageType{
        FEATURE, NORMAL
    }
}
