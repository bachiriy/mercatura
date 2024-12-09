package com.mercatura.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mercatura.api.dto.product.*;
import com.mercatura.api.service.ProductService;
import com.mercatura.api.util.Response;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired private ProductService service;

    @GetMapping
    public List<GetProductDto> index(){
        return service.getAll();
    }

    @PostMapping
    public GetProductDto add(@Valid @RequestBody PostProductDto product){
        return service.add(product);
    }

    @PatchMapping("/{id}")
    public GetProductDto patch(@PathVariable Long id, @RequestBody PatchProductDto patchDto){
        return service.update(id, patchDto);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id){
        return service.remove(id);
    }
}
