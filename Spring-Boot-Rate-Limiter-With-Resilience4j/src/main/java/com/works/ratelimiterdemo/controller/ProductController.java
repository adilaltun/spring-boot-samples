package com.works.ratelimiterdemo.controller;

import com.works.ratelimiterdemo.model.Product;
import com.works.ratelimiterdemo.service.ProductService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product save = productService.save(product);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    @RateLimiter(name = "rateLimiterAPI")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> allProduct = productService.getAllProduct();
        return new ResponseEntity<>(allProduct,HttpStatus.OK);
    }

}
