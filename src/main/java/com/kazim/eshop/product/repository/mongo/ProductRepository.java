package com.kazim.eshop.product.repository.mongo;

// import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.kazim.eshop.product.domain.Product;

public interface ProductRepository  extends ReactiveMongoRepository<Product, String>{
    
}
