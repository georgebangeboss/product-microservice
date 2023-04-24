package com.bangeboss.productservice.service;

import com.bangeboss.productservice.dtos.ProductRequest;
import com.bangeboss.productservice.dtos.ProductResponse;
import com.bangeboss.productservice.model.Product;
import com.bangeboss.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product =Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        productRepository.insert(product);
        log.info("Product {} has been saved",product.getId());
    }
    public ProductResponse createProduct2(ProductRequest productRequest){
        Product product =Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        productRepository.insert(product);
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> allProducts= productRepository.findAll();

        return allProducts.stream()
                .map((product)->ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
