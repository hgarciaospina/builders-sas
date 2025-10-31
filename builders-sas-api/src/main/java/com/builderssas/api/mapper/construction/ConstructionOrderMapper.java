package com.builderssas.api.mapper.construction;

import com.builderssas.api.domain.model.construction.ConstructionOrder;
import com.builderssas.api.domain.model.construction.dto.ConstructionOrderDto;
import com.builderssas.api.domain.model.construction.dto.CreateConstructionOrderDto;
import com.builderssas.api.domain.model.construction.dto.UpdateConstructionOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ConstructionOrderMapper {

    ConstructionOrderDto toDto(ConstructionOrder order);

    ConstructionOrder toEntity(CreateConstructionOrderDto dto);

    void updateEntityFromDto(UpdateConstructionOrderDto dto, @MappingTarget ConstructionOrder order);

    List<ConstructionOrderDto> toDtos(List<ConstructionOrder> orders);

    Set<ConstructionOrderDto> toDtoSet(Set<ConstructionOrder> orders);
}