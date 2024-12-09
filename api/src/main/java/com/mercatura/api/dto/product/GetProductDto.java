package com.mercatura.api.dto.product;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductDto {
    Long id;
    String designation;
    Double price;
    Integer quantity;
    String category_name;
    Long category_id;
}
