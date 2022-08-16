package com.kazim.eshop.product.repository.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.kazim.eshop.product.domain.category.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
    
}
