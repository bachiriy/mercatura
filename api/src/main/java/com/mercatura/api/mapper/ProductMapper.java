package com.mercatura.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mercatura.api.dto.product.GetProductDto;
import com.mercatura.api.dto.product.PatchProductDto;
import com.mercatura.api.dto.product.PostProductDto;
import com.mercatura.api.entity.Product;
import com.mercatura.api.service.CategoryService;


@Mapper(componentModel = "spring", uses = {CategoryService.class})
public interface ProductMapper {
    @Mapping(source = "category_id", target = "category")
    Product toEntity(PostProductDto dto);

    @Mapping(source = "category.id", target = "category_id")
    GetProductDto toGetDto(Product product);

    @Mapping(source = "category_id", target = "category")
    Product toEntity(PatchProductDto dto);
}
