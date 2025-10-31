package com.builderssas.api.mapper.user;

import com.builderssas.api.domain.model.user.*;
import com.builderssas.api.domain.model.user.dto.CreateUserDto;
import com.builderssas.api.domain.model.user.dto.UpdateUserDto;
import com.builderssas.api.domain.model.user.dto.UserDto;
import org.mapstruct.*;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(CreateUserDto dto);

    void updateEntityFromDto(UpdateUserDto dto, @MappingTarget User user);

    List<UserDto> toDtos(List<User> users);

    Set<UserDto> toDtoSet(Set<User> users);
}