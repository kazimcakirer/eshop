package com.kazim.eshop.product.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.kazim.eshop.product.domain.MoneyTypes;

@Service
public class ProductPriceService {
    

    public BigDecimal getByMoneyType(String id, MoneyTypes type){
        return BigDecimal.TEN;
    }

}
