package com.kazim.eshop.product.service;

import java.math.BigDecimal;

public class ProductDeliveryService {

    public String getDeliveryInfo(String productId) {
        return "Tomorrow";
    }

    public boolean freeDeliveryCheck(String productId, BigDecimal price) {
        return price.compareTo(BigDecimal.ONE) >= 0;
    }
}
