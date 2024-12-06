package com.mercatura.api.service;

import java.util.List;

import com.mercatura.api.entity.Product;


public interface ProductService {
    List<Product> getAll();
    Product findById(Long id);
    Product update(Long id, Product product);
    Product add(Product product);
    String remove(Long id);
}
