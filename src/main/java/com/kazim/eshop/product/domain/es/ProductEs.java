package com.kazim.eshop.product.domain.es;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "product")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ProductEs {

    private String id;
    private String name;
    private String code;
    private String description;
    private CompanyEs seller;
    private String features;
    private CategoryEs category;
    private Boolean active;

}
