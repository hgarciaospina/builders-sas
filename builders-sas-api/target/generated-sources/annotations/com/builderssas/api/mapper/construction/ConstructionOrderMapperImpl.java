package com.builderssas.api.mapper.construction;

import com.builderssas.api.domain.model.construction.ConstructionOrder;
import com.builderssas.api.domain.model.construction.dto.ConstructionOrderDto;
import com.builderssas.api.domain.model.construction.dto.CreateConstructionOrderDto;
import com.builderssas.api.domain.model.construction.dto.UpdateConstructionOrderDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-31T16:37:03-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class ConstructionOrderMapperImpl implements ConstructionOrderMapper {

    @Override
    public ConstructionOrderDto toDto(ConstructionOrder order) {
        if ( order == null ) {
            return null;
        }

        ConstructionOrderDto constructionOrderDto = new ConstructionOrderDto();

        return constructionOrderDto;
    }

    @Override
    public ConstructionOrder toEntity(CreateConstructionOrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        ConstructionOrder constructionOrder = new ConstructionOrder();

        return constructionOrder;
    }

    @Override
    public void updateEntityFromDto(UpdateConstructionOrderDto dto, ConstructionOrder order) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<ConstructionOrderDto> toDtos(List<ConstructionOrder> orders) {
        if ( orders == null ) {
            return null;
        }

        List<ConstructionOrderDto> list = new ArrayList<ConstructionOrderDto>( orders.size() );
        for ( ConstructionOrder constructionOrder : orders ) {
            list.add( toDto( constructionOrder ) );
        }

        return list;
    }

    @Override
    public Set<ConstructionOrderDto> toDtoSet(Set<ConstructionOrder> orders) {
        if ( orders == null ) {
            return null;
        }

        Set<ConstructionOrderDto> set = new LinkedHashSet<ConstructionOrderDto>( Math.max( (int) ( orders.size() / .75f ) + 1, 16 ) );
        for ( ConstructionOrder constructionOrder : orders ) {
            set.add( toDto( constructionOrder ) );
        }

        return set;
    }
}
