package com.builderssas.api.mapper.user;

import com.builderssas.api.domain.model.user.UserRole;
import com.builderssas.api.domain.model.user.dto.CreateUserRoleDto;
import com.builderssas.api.domain.model.user.dto.UpdateUserRoleDto;
import com.builderssas.api.domain.model.user.dto.UserRoleDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-31T18:18:58-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UserRoleDto toDto(UserRole userRole) {
        if ( userRole == null ) {
            return null;
        }

        UserRoleDto userRoleDto = new UserRoleDto();

        return userRoleDto;
    }

    @Override
    public UserRole toEntity(CreateUserRoleDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserRole userRole = new UserRole();

        return userRole;
    }

    @Override
    public void updateEntityFromDto(UpdateUserRoleDto dto, UserRole userRole) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<UserRoleDto> toDtos(List<UserRole> userRoles) {
        if ( userRoles == null ) {
            return null;
        }

        List<UserRoleDto> list = new ArrayList<UserRoleDto>( userRoles.size() );
        for ( UserRole userRole : userRoles ) {
            list.add( toDto( userRole ) );
        }

        return list;
    }

    @Override
    public Set<UserRoleDto> toDtoSet(Set<UserRole> userRoles) {
        if ( userRoles == null ) {
            return null;
        }

        Set<UserRoleDto> set = new LinkedHashSet<UserRoleDto>( Math.max( (int) ( userRoles.size() / .75f ) + 1, 16 ) );
        for ( UserRole userRole : userRoles ) {
            set.add( toDto( userRole ) );
        }

        return set;
    }
}
