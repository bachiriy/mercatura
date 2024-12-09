package com.mercatura.api.dto.category;

import java.util.List;
import com.mercatura.api.dto.product.GetProductDto;

import lombok.*;


@Data
@Builder
public class GetCategoryDto {
    Long id;
    String name;
    String description;
    List<GetProductDto> products;    
}
