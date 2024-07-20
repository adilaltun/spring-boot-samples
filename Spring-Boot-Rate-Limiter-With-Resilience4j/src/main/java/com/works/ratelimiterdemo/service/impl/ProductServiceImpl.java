package com.works.ratelimiterdemo.service.impl;

import com.works.ratelimiterdemo.model.Product;
import com.works.ratelimiterdemo.repository.ProductRepository;
import com.works.ratelimiterdemo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        Product save = productRepository.save(product);
        return save;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> getAllProduct = productRepository.findAll();
        return getAllProduct;
    }
}
