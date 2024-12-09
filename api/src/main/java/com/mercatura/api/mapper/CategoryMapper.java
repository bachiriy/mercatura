package com.mercatura.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mercatura.api.dto.category.GetCategoryDto;
import com.mercatura.api.dto.category.PatchCategoryDto;
import com.mercatura.api.dto.category.PostCategoryDto;
import com.mercatura.api.entity.Category;
import com.mercatura.api.service.CategoryService;

@Mapper(componentModel = "spring", uses = {CategoryService.class})
public interface CategoryMapper {
    Category toEntity(PostCategoryDto dto);

    @Mapping(source = "products", target = "products")
    GetCategoryDto toGetDto(Category category);

    Category toEntity(PatchCategoryDto dto);
}
