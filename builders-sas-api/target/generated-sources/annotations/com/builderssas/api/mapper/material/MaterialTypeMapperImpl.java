package com.builderssas.api.mapper.material;

import com.builderssas.api.domain.model.material.MaterialType;
import com.builderssas.api.domain.model.material.dto.CreateMaterialTypeDto;
import com.builderssas.api.domain.model.material.dto.MaterialTypeDto;
import com.builderssas.api.domain.model.material.dto.UpdateMaterialTypeDto;
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
public class MaterialTypeMapperImpl implements MaterialTypeMapper {

    @Override
    public MaterialTypeDto toDto(MaterialType type) {
        if ( type == null ) {
            return null;
        }

        MaterialTypeDto materialTypeDto = new MaterialTypeDto();

        return materialTypeDto;
    }

    @Override
    public MaterialType toEntity(CreateMaterialTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        MaterialType materialType = new MaterialType();

        return materialType;
    }

    @Override
    public void updateEntityFromDto(UpdateMaterialTypeDto dto, MaterialType type) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<MaterialTypeDto> toDtos(List<MaterialType> types) {
        if ( types == null ) {
            return null;
        }

        List<MaterialTypeDto> list = new ArrayList<MaterialTypeDto>( types.size() );
        for ( MaterialType materialType : types ) {
            list.add( toDto( materialType ) );
        }

        return list;
    }

    @Override
    public Set<MaterialTypeDto> toDtoSet(Set<MaterialType> types) {
        if ( types == null ) {
            return null;
        }

        Set<MaterialTypeDto> set = new LinkedHashSet<MaterialTypeDto>( Math.max( (int) ( types.size() / .75f ) + 1, 16 ) );
        for ( MaterialType materialType : types ) {
            set.add( toDto( materialType ) );
        }

        return set;
    }
}
