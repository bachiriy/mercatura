package com.mercatura.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercatura.api.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
