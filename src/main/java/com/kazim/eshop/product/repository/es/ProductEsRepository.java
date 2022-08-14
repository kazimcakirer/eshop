package com.kazim.eshop.product.repository.es;

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

import com.kazim.eshop.product.domain.es.ProductEs;

public interface ProductEsRepository extends ReactiveElasticsearchRepository<ProductEs,String>{
    
}
