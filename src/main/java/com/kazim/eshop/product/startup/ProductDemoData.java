package com.kazim.eshop.product.startup;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.kazim.eshop.product.domain.MoneyTypes;
import com.kazim.eshop.product.model.category.CategoryResponse;
import com.kazim.eshop.product.model.category.CategorySaveRequest;
import com.kazim.eshop.product.model.product.ProductSaveRequest;
import com.kazim.eshop.product.service.CategoryService;
import com.kazim.eshop.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductDemoData {

    private final ProductService productService;
    private final CategoryService categoryService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {
        Long countOfData = productService.count().block();
        if (countOfData.equals(0L)) {
            CategoryResponse elektronik = categoryService.save(CategorySaveRequest.builder().name("Elektronik").build());
            CategoryResponse telefon = categoryService.save(CategorySaveRequest.builder().name("Cep Telefonu").build());
            IntStream.range(0,20).forEach(item -> {
                HashMap<MoneyTypes, BigDecimal> price = new HashMap<>() {{
                    put(MoneyTypes.USD, BigDecimal.valueOf((item + 1) * 5));
                    put(MoneyTypes.EUR, BigDecimal.valueOf((item + 1) * 4));
                }};
                productService.save(
                    ProductSaveRequest.builder()
                    .sellerId(UUID.randomUUID().toString())
                    .id(UUID.randomUUID().toString())
                    .description("Pro Description  ")
                    .categoryId(telefon.getId())
                    .name("Product name")
                    .features("test özelleri")
                    .price(price)
                    .images(List.of("test.image"))
                    .build()

                );
            });
        }
    }
}
