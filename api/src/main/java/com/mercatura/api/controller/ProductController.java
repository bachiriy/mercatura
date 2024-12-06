package com.mercatura.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercatura.api.entity.Product;
import com.mercatura.api.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired private ProductService service;

    @GetMapping
    public List<Product> index(){
        return service.getAll();
    }

    @PostMapping
    public Product add(Product product){
        return service.add(product);
    }

    @PatchMapping("/{id}")
    public Product patch(@PathVariable Long id, @RequestBody Product product){
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return service.remove(id);
    }
}
