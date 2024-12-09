package com.mercatura.api.dto.product;

import javax.validation.constraints.NotNull;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostProductDto {
    @NotNull(message = "designation is required.")
    String designation;

    @NotNull(message = "price is required.")
    Double price;

    @NotNull(message = "quantity is required.")
    Integer quantity;

    @NotNull(message = "product must be associated with category (category_id missing).")
    Long category_id;
}
