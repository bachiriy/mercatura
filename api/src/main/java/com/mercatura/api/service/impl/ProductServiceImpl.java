package com.mercatura.api.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercatura.api.dto.product.*;
import com.mercatura.api.entity.Product;
import com.mercatura.api.exception.DuplicationElementException;
import com.mercatura.api.exception.ElementNotFoundException;
import com.mercatura.api.mapper.ProductMapper;
import com.mercatura.api.repository.ProductRepository;
import com.mercatura.api.service.ProductService;
import com.mercatura.api.util.Response;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired private ProductRepository repository;

    @Autowired private ProductMapper mapper;

    public List<GetProductDto> getAll(){
        return repository.findAll().stream().map(p -> mapper.toGetDto(p)).collect(Collectors.toList());
    }

    public GetProductDto add(PostProductDto dto){
        Product p = mapper.toEntity(dto);
        if(!repository.existsByDesignationAndPriceAndQuantity(p.getDesignation(), p.getPrice(), p.getQuantity())){
            return mapper.toGetDto(repository.save(p));
        } else throw new DuplicationElementException("product");
    }

    public GetProductDto findById(Long id){
        return repository.findById(id).map(mapper::toGetDto).orElseThrow(() -> new ElementNotFoundException("product", id));
    }
    public GetProductDto update(Long id, PatchProductDto dto){
        Product p = get(id); // will fail if product does not exist

        Product patchProduct = mapper.toEntity(dto);

        Product updatedProduct = Product.builder()
            .designation(patchProduct.getDesignation() != null ? patchProduct.getDesignation() : p.getDesignation())
            .price(patchProduct.getPrice() != null ? patchProduct.getPrice() : p.getPrice())
            .quantity(patchProduct.getQuantity() != null ? patchProduct.getQuantity() : p.getQuantity())
            .category(patchProduct.getCategory() != null ? patchProduct.getCategory() : p.getCategory())
            .build();
        
        repository.save(updatedProduct);
        return mapper.toGetDto(updatedProduct); 
    }

    public Response remove(Long id){
        findById(id);
        repository.deleteById(id);
        return Response.builder().code(200).status("SUCCESS").success(Arrays.asList("product deleted.")).build();
    }

    public Product get(Long id){
        return repository.findById(id).orElseThrow(() -> new ElementNotFoundException("product", id));
    }
}
