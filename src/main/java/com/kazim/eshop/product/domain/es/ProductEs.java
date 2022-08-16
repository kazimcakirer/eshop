package com.kazim.eshop.product.domain.es;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.data.elasticsearch.annotations.Document;

import com.kazim.eshop.product.domain.MoneyTypes;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "product")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class ProductEs {

    private String id;
    private String name;
    private String code;
    private String description;
    private CompanyEs seller;
    private String features;
    private CategoryEs category;
    private HashMap<MoneyTypes, BigDecimal> price;
    private Boolean active;

}
