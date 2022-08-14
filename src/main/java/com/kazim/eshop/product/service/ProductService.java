package com.kazim.eshop.product.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.kazim.eshop.product.domain.MoneyTypes;
import com.kazim.eshop.product.domain.es.ProductEs;
import com.kazim.eshop.product.model.ProductResponse;
import com.kazim.eshop.product.model.ProductSaveRequest;
import com.kazim.eshop.product.model.ProductSellerReponse;
import com.kazim.eshop.product.repository.es.ProductEsRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEsRepository productEsRepository;
    private final ProductPriceService productPriceService;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;

    public Flux<ProductResponse> getAll() {
        return productEsRepository.findAll().map(this::mapToDto);
    }

    ProductResponse save(ProductSaveRequest productSaveRequest) {
        return null;
    }

    private  ProductResponse mapToDto(ProductEs item) {
        BigDecimal productPrice = productPriceService.getByMoneyType(item.getId(), MoneyTypes.USD);
        return ProductResponse.builder()
        .price(productPrice)
        .name(item.getName())
        .features(item.getFeatures())
        .id(item.getId())
        .description(item.getDescription())
        .deliveryIn(productDeliveryService.getDeliveryInfo(item.getId()))
        .categoryId(item.getCategory().getId())
        .available(productAmountService.getByProductId(item.getId()))
        .freeDelivery(productDeliveryService.freeDeliveryCheck(item.getId(), productPrice))
        .moneyType(MoneyTypes.TL)
        .image(productImageService.getProductMainImage(item.getId()))
        .seller(ProductSellerReponse.builder().id(item.getSeller().getId()).name(item.getSeller().getName()).build())
        .build();

        
    }
}
