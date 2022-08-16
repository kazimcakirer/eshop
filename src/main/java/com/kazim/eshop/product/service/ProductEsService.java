package com.kazim.eshop.product.service;

import org.springframework.stereotype.Service;

import com.kazim.eshop.product.domain.Product;
import com.kazim.eshop.product.domain.category.Category;
import com.kazim.eshop.product.domain.es.CategoryEs;
import com.kazim.eshop.product.domain.es.CompanyEs;
import com.kazim.eshop.product.domain.es.ProductEs;
import com.kazim.eshop.product.repository.es.ProductEsRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductEsService {
    
    private final ProductEsRepository productEsRepository;
    private final CategoryService categoryService;

    public Mono<ProductEs> saveNewProduct(Product product) {
        return productEsRepository.save(
            ProductEs.builder()
            .active(product.getActive())
            .code(product.getCode())
            .description(product.getDescription())
            .features(product.getFeatures())
            .id(product.getId())
            .name(product.getName())
            .seller(CompanyEs.builder().id(product.getCompanyId()).name("test").build())
            .category(CategoryEs.builder().id(product.getCategoryId()).name("test").build())
            .price(product.getPrice())
            .build()
        );
    }

    public CategoryEs getProductCategory(String categoryId) {
        Category category = categoryService.getById(categoryId);
        return CategoryEs.builder().name(category.getName()).id(category.getId()).code(category.getCode()).build();
    }

    public Flux<ProductEs> findAll() {
        return productEsRepository.findAll();
    }
}
