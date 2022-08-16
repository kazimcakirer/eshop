package com.kazim.eshop.product.service;

import java.math.BigDecimal;

import com.kazim.eshop.product.domain.MoneyTypes;

public class ProductDeliveryService {

    public String getDeliveryInfo(String productId) {
        return "Tomorrow";
    }

    public boolean freeDeliveryCheck(String productId, BigDecimal price, MoneyTypes moneyType) {
        return true;
    }
}
