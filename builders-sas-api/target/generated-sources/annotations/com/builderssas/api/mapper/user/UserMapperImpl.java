package com.builderssas.api.mapper.user;

import com.builderssas.api.domain.model.user.User;
import com.builderssas.api.domain.model.user.dto.CreateUserDto;
import com.builderssas.api.domain.model.user.dto.UpdateUserDto;
import com.builderssas.api.domain.model.user.dto.UserDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-31T21:04:35-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        return userDto;
    }

    @Override
    public User toEntity(CreateUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public void updateEntityFromDto(UpdateUserDto dto, User user) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<UserDto> toDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public Set<UserDto> toDtoSet(Set<User> users) {
        if ( users == null ) {
            return null;
        }

        Set<UserDto> set = new LinkedHashSet<UserDto>( Math.max( (int) ( users.size() / .75f ) + 1, 16 ) );
        for ( User user : users ) {
            set.add( toDto( user ) );
        }

        return set;
    }
}
