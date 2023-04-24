package com.bangeboss.productservice.controller;

import com.bangeboss.productservice.dtos.ProductRequest;
import com.bangeboss.productservice.dtos.ProductResponse;
import com.bangeboss.productservice.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping(value ="product/create1")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }
    @PostMapping(value ="product/create2")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct2(@RequestBody ProductRequest productRequest){
        return productService.createProduct2(productRequest);
    }

    @GetMapping(value="products")
    public ResponseEntity<List<ProductResponse>>  getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
