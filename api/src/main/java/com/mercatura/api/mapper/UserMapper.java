package com.mercatura.api.mapper;

import org.mapstruct.Mapper;

import com.mercatura.api.dto.user.PostUserDto;
import com.mercatura.api.entity.User;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {
    User toEntity(PostUserDto dto);

    // @Mapping(source = "users", target = "products")
    // GetUserDto toGetDto(User user);

    // User toEntity(PatchUserDto dto);
}
