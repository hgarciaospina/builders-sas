package com.builderssas.api.mapper.user;

import com.builderssas.api.domain.model.user.Role;
import com.builderssas.api.domain.model.user.dto.CreateRoleDto;
import com.builderssas.api.domain.model.user.dto.RoleDto;
import com.builderssas.api.domain.model.user.dto.UpdateRoleDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-01T09:43:56-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        return roleDto;
    }

    @Override
    public Role toEntity(CreateRoleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        return role;
    }

    @Override
    public void updateEntityFromDto(UpdateRoleDto dto, Role role) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<RoleDto> toDtos(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( roles.size() );
        for ( Role role : roles ) {
            list.add( toDto( role ) );
        }

        return list;
    }

    @Override
    public Set<RoleDto> toDtoSet(Set<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        Set<RoleDto> set = new LinkedHashSet<RoleDto>( Math.max( (int) ( roles.size() / .75f ) + 1, 16 ) );
        for ( Role role : roles ) {
            set.add( toDto( role ) );
        }

        return set;
    }
}
