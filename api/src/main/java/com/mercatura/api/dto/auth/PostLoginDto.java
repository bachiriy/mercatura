package com.mercatura.api.dto.auth;

import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostLoginDto {

    @NotNull(message = "username is required.")
    String username;

    @NotNull(message = "password is required.")
    String password;
}
