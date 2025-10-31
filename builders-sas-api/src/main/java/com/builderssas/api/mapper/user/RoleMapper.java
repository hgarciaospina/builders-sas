package com.builderssas.api.mapper.user;

import com.builderssas.api.domain.model.user.Role;
import com.builderssas.api.domain.model.user.dto.CreateRoleDto;
import com.builderssas.api.domain.model.user.dto.RoleDto;
import com.builderssas.api.domain.model.user.dto.UpdateRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper (componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);

    Role toEntity(CreateRoleDto dto);

    void updateEntityFromDto(UpdateRoleDto dto, @MappingTarget  Role role);

    List<RoleDto> toDtos(List<Role> roles);

    Set<RoleDto> toDtoSet(Set<Role> roles);
}