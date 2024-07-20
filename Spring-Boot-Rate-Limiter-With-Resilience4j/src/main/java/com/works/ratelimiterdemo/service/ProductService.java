package com.works.ratelimiterdemo.service;

import com.works.ratelimiterdemo.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> getAllProduct();

}
