package com.mercatura.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mercatura.api.dto.product.*;
import com.mercatura.api.entity.Product;
import com.mercatura.api.util.Response;


@Service
public interface ProductService {
    List<GetProductDto> getAll();
    GetProductDto findById(Long id);
    GetProductDto update(Long id, PatchProductDto product);
    GetProductDto add(PostProductDto product);
    Response remove(Long id);
    Product get(Long id);
}
