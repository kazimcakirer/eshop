package com.kazim.eshop.product.domain.category;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Document(collection="category")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of="id")
public class Category {
    @Id
    private String id;
    private String name;
    private String code;
}
