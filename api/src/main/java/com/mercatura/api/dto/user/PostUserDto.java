package com.mercatura.api.dto.user;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostUserDto {
    String username;
    String password;
}
