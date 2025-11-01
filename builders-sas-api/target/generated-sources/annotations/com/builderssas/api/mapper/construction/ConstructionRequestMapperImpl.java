package com.builderssas.api.mapper.construction;

import com.builderssas.api.domain.model.construction.ConstructionRequest;
import com.builderssas.api.domain.model.construction.dto.ConstructionRequestDto;
import com.builderssas.api.domain.model.construction.dto.CreateConstructionRequestDto;
import com.builderssas.api.domain.model.construction.dto.UpdateConstructionRequestDto;
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
public class ConstructionRequestMapperImpl implements ConstructionRequestMapper {

    @Override
    public ConstructionRequestDto toDto(ConstructionRequest request) {
        if ( request == null ) {
            return null;
        }

        ConstructionRequestDto constructionRequestDto = new ConstructionRequestDto();

        return constructionRequestDto;
    }

    @Override
    public ConstructionRequest toEntity(CreateConstructionRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ConstructionRequest constructionRequest = new ConstructionRequest();

        return constructionRequest;
    }

    @Override
    public void updateEntityFromDto(UpdateConstructionRequestDto dto, ConstructionRequest request) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<ConstructionRequestDto> toDtos(List<ConstructionRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        List<ConstructionRequestDto> list = new ArrayList<ConstructionRequestDto>( requests.size() );
        for ( ConstructionRequest constructionRequest : requests ) {
            list.add( toDto( constructionRequest ) );
        }

        return list;
    }

    @Override
    public Set<ConstructionRequestDto> toDtoSet(Set<ConstructionRequest> requests) {
        if ( requests == null ) {
            return null;
        }

        Set<ConstructionRequestDto> set = new LinkedHashSet<ConstructionRequestDto>( Math.max( (int) ( requests.size() / .75f ) + 1, 16 ) );
        for ( ConstructionRequest constructionRequest : requests ) {
            set.add( toDto( constructionRequest ) );
        }

        return set;
    }
}
