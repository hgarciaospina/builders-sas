package com.builderssas.api.mapper.user;

import com.builderssas.api.domain.model.user.UserRole;
import com.builderssas.api.domain.model.user.dto.CreateUserRoleDto;
import com.builderssas.api.domain.model.user.dto.UpdateUserRoleDto;
import com.builderssas.api.domain.model.user.dto.UserRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {UserMapper.class, RoleMapper.class})
public interface UserRoleMapper {

    UserRoleDto toDto(UserRole userRole);

    UserRole toEntity(CreateUserRoleDto dto);

    void updateEntityFromDto(UpdateUserRoleDto dto, @MappingTarget UserRole userRole);

    List<UserRoleDto> toDtos(List<UserRole> userRoles);

    Set<UserRoleDto> toDtoSet(Set<UserRole> userRoles);
}