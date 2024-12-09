package com.mercatura.api.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercatura.api.dto.category.GetCategoryDto;
import com.mercatura.api.dto.category.PatchCategoryDto;
import com.mercatura.api.dto.category.PostCategoryDto;
import com.mercatura.api.entity.Category;
import com.mercatura.api.exception.DuplicationElementException;
import com.mercatura.api.exception.ElementNotFoundException;
import com.mercatura.api.mapper.CategoryMapper;
import com.mercatura.api.repository.CategoryRepository;
import com.mercatura.api.service.CategoryService;
import com.mercatura.api.util.Response;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired private CategoryRepository repository;

    @Autowired private CategoryMapper mapper;

    public List<GetCategoryDto> getAll(){
        return repository.findAll().stream().map(p -> mapper.toGetDto(p)).collect(Collectors.toList());
    }

    public GetCategoryDto add(PostCategoryDto dto){
        Category p = mapper.toEntity(dto);
        if(!repository.existsByNameAndDescription(p.getName(), p.getDescription())){
            return mapper.toGetDto(repository.save(p));
        } else throw new DuplicationElementException("category");
    }

    public GetCategoryDto findById(Long id){
        return repository.findById(id).map(mapper::toGetDto).orElseThrow(() -> new ElementNotFoundException("category", id));
    }
    public GetCategoryDto update(Long id, PatchCategoryDto dto){
        Category p = get(id); // will fail if category does not exist

        Category patchCategory = mapper.toEntity(dto);

        Category updatedCategory = Category.builder()
            .description(patchCategory.getDescription() != null ? patchCategory.getDescription() : p.getDescription())
            .name(patchCategory.getName() != null ? patchCategory.getName() : p.getName())
            .products(patchCategory.getProducts() != null ? patchCategory.getProducts() : p.getProducts())
            .build();
        
        repository.save(updatedCategory);
        return mapper.toGetDto(updatedCategory); 
    }

    public Response remove(Long id){
        findById(id);
        repository.deleteById(id);
        return Response.builder().code(200).status("SUCCESS").success(Arrays.asList("category deleted.")).build();
    }

    public Category get(Long id){
        return repository.findById(id).orElseThrow(() -> new ElementNotFoundException("category", id));
    }
}
