package com.builderssas.api.mapper.construction;

import com.builderssas.api.domain.model.construction.ConstructionTypeMaterial;
import com.builderssas.api.domain.model.construction.dto.ConstructionTypeMaterialDto;
import com.builderssas.api.domain.model.construction.dto.CreateConstructionTypeMaterialDto;
import com.builderssas.api.domain.model.construction.dto.UpdateConstructionTypeMaterialDto;
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
public class ConstructionTypeMaterialMapperImpl implements ConstructionTypeMaterialMapper {

    @Override
    public ConstructionTypeMaterialDto toDto(ConstructionTypeMaterial ctm) {
        if ( ctm == null ) {
            return null;
        }

        ConstructionTypeMaterialDto constructionTypeMaterialDto = new ConstructionTypeMaterialDto();

        return constructionTypeMaterialDto;
    }

    @Override
    public ConstructionTypeMaterial toEntity(CreateConstructionTypeMaterialDto dto) {
        if ( dto == null ) {
            return null;
        }

        ConstructionTypeMaterial constructionTypeMaterial = new ConstructionTypeMaterial();

        return constructionTypeMaterial;
    }

    @Override
    public void updateEntityFromDto(UpdateConstructionTypeMaterialDto dto, ConstructionTypeMaterial ctm) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<ConstructionTypeMaterialDto> toDtos(List<ConstructionTypeMaterial> ctms) {
        if ( ctms == null ) {
            return null;
        }

        List<ConstructionTypeMaterialDto> list = new ArrayList<ConstructionTypeMaterialDto>( ctms.size() );
        for ( ConstructionTypeMaterial constructionTypeMaterial : ctms ) {
            list.add( toDto( constructionTypeMaterial ) );
        }

        return list;
    }

    @Override
    public Set<ConstructionTypeMaterialDto> toDtoSet(Set<ConstructionTypeMaterial> ctms) {
        if ( ctms == null ) {
            return null;
        }

        Set<ConstructionTypeMaterialDto> set = new LinkedHashSet<ConstructionTypeMaterialDto>( Math.max( (int) ( ctms.size() / .75f ) + 1, 16 ) );
        for ( ConstructionTypeMaterial constructionTypeMaterial : ctms ) {
            set.add( toDto( constructionTypeMaterial ) );
        }

        return set;
    }
}
