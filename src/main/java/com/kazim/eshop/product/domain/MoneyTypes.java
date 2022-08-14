package com.kazim.eshop.product.domain;

import lombok.Getter;

@Getter
public enum MoneyTypes {
    USD ("Dolar", "$"),
    EUR ("Euro", "€"),
    TL ("Türk Lirasi", "₺");

    private String label;

    private String symbol;

    MoneyTypes(String label, String symbol) {
        this.label = label;
        this.symbol = symbol;
    }
}