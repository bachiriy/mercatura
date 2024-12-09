package com.mercatura.api.dto.product;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatchProductDto {
    Long id;

    String designation;

    Double price;

    Integer quantity;
    
    Long category_id;
}
