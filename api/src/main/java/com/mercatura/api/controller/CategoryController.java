package com.mercatura.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercatura.api.dto.category.GetCategoryDto;
import com.mercatura.api.dto.category.PatchCategoryDto;
import com.mercatura.api.dto.category.PostCategoryDto;
import com.mercatura.api.service.CategoryService;
import com.mercatura.api.util.Response;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired private CategoryService service;
    
    @GetMapping
    public List<GetCategoryDto> index(){
        return service.getAll();
    }

    @PostMapping
    public GetCategoryDto add(@Valid PostCategoryDto category){
        return service.add(category);
    }

    @PatchMapping("/{id}")
    public GetCategoryDto patch(@PathVariable Long id, @RequestBody PatchCategoryDto category){
        return service.update(id, category);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id){
        return service.remove(id);
    }
}
