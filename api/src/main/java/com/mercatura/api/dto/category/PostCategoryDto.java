package com.mercatura.api.dto.category;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCategoryDto {
    String name;
    String description;    
}
