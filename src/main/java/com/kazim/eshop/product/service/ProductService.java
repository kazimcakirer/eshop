package com.kazim.eshop.product.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.kazim.eshop.product.domain.MoneyTypes;
import com.kazim.eshop.product.domain.Product;
import com.kazim.eshop.product.domain.ProductImage;
import com.kazim.eshop.product.domain.es.ProductEs;
import com.kazim.eshop.product.model.ProductSellerReponse;
import com.kazim.eshop.product.model.product.ProductResponse;
import com.kazim.eshop.product.model.product.ProductSaveRequest;
import com.kazim.eshop.product.repository.es.ProductEsRepository;
import com.kazim.eshop.product.repository.mongo.ProductRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductPriceService productPriceService;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;
    private final ProductEsService productEsService;

    public Flux<ProductResponse> getAll() {
        return productEsService.findAll().map(this::mapToDto);
    }

    public ProductResponse save(ProductSaveRequest request) {
        Product product = Product.builder()
                .active(Boolean.TRUE)
                .code("cr0001")
                .categoryId(request.getCategoryId())
                .companyId(request.getSellerId())
                .description(request.getDescription())
                .features(request.getFeatures())
                .name(request.getName())
                .productImage(request.getImages())
                .price(request.getPrice())
                .build();
        product = productRepository.save(product).block();
        return this.mapToDto(productEsService.saveNewProduct(product).block());
    }

    private ProductResponse mapToDto(ProductEs item) {
        if (item == null) {
            return null;
        }

        return ProductResponse.builder()
                .price(item.getPrice().get("USD"))
                .moneySymbol(MoneyTypes.USD.getSymbol())
                .name(item.getName())
                .features(item.getFeatures())
                .id(item.getId())
                .description(item.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryInfo(item.getId()))
                .categoryId(item.getCategory().getId())
                .available(productAmountService.getByProductId(item.getId()))
                .freeDelivery(productDeliveryService.freeDeliveryCheck(item.getId(), item.getPrice().get("USD"), MoneyTypes.USD))
                .image(productImageService.getProductMainImage(item.getId()))
                .seller(ProductSellerReponse.builder().id(item.getSeller().getId()).name(item.getSeller().getName())
                        .build())
                .build();

    }

    public Mono<Long> count() {
        return productRepository.count();
    }
}
