package com.mercatura.api.dto.category;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchCategoryDto {
    Long id;
    String name;
    String description;    
}
