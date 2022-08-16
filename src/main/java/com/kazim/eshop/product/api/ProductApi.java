package com.kazim.eshop.product.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kazim.eshop.product.model.product.ProductResponse;
import com.kazim.eshop.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductApi {
    
    private final ProductService productService;

    public Flux<ProductResponse> getAllProduct(){
        return productService.getAll();
    }
}
