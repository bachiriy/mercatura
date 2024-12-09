package com.mercatura.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mercatura.api.dto.category.*;
import com.mercatura.api.entity.Category;
import com.mercatura.api.util.Response;


@Service
public interface CategoryService {
    List<GetCategoryDto> getAll();
    GetCategoryDto findById(Long id);
    GetCategoryDto update(Long id, PatchCategoryDto category);
    GetCategoryDto add(PostCategoryDto category);
    Response remove(Long id);
    Category get(Long id);
}
