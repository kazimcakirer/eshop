package com.kazim.eshop.product.domain;

import lombok.Data;

@Data
public class ProductImage {
    
    private ImageType ImageType;
    private String url;

    public enum ImageType{
        FEATURE, NORMAL
    }
}
