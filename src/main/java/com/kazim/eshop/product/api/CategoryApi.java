package com.kazim.eshop.product.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kazim.eshop.product.model.category.CategoryResponse;
import com.kazim.eshop.product.service.CategoryService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryApi {
    
    private final CategoryService categoryService;
    
    @GetMapping
    public Flux<CategoryResponse> getAll() {
        return categoryService.getAll();
    }
}
