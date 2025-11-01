package com.builderssas.api.mapper.construction;

import com.builderssas.api.domain.model.construction.ConstructionType;
import com.builderssas.api.domain.model.construction.dto.ConstructionTypeDto;
import com.builderssas.api.domain.model.construction.dto.CreateConstructionTypeDto;
import com.builderssas.api.domain.model.construction.dto.UpdateConstructionTypeDto;
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
public class ConstructionTypeMapperImpl implements ConstructionTypeMapper {

    @Override
    public ConstructionTypeDto toDto(ConstructionType type) {
        if ( type == null ) {
            return null;
        }

        ConstructionTypeDto constructionTypeDto = new ConstructionTypeDto();

        return constructionTypeDto;
    }

    @Override
    public ConstructionType toEntity(CreateConstructionTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        ConstructionType constructionType = new ConstructionType();

        return constructionType;
    }

    @Override
    public void updateEntityFromDto(UpdateConstructionTypeDto dto, ConstructionType type) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<ConstructionTypeDto> toDtos(List<ConstructionType> types) {
        if ( types == null ) {
            return null;
        }

        List<ConstructionTypeDto> list = new ArrayList<ConstructionTypeDto>( types.size() );
        for ( ConstructionType constructionType : types ) {
            list.add( toDto( constructionType ) );
        }

        return list;
    }

    @Override
    public Set<ConstructionTypeDto> toDtoSet(Set<ConstructionType> types) {
        if ( types == null ) {
            return null;
        }

        Set<ConstructionTypeDto> set = new LinkedHashSet<ConstructionTypeDto>( Math.max( (int) ( types.size() / .75f ) + 1, 16 ) );
        for ( ConstructionType constructionType : types ) {
            set.add( toDto( constructionType ) );
        }

        return set;
    }
}
