package com.works.ratelimiterdemo.repository;

import com.works.ratelimiterdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
