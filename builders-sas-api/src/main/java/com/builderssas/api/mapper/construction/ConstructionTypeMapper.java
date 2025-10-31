package com.builderssas.api.mapper.construction;

import com.builderssas.api.domain.model.construction.ConstructionType;
import com.builderssas.api.domain.model.construction.dto.ConstructionTypeDto;
import com.builderssas.api.domain.model.construction.dto.CreateConstructionTypeDto;
import com.builderssas.api.domain.model.construction.dto.UpdateConstructionTypeDto;
import com.builderssas.api.mapper.project.ProjectConstructionMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ConstructionTypeMapper {

    ConstructionTypeDto toDto(ConstructionType type);

    ConstructionType toEntity(CreateConstructionTypeDto dto);

    void updateEntityFromDto(UpdateConstructionTypeDto dto, @MappingTarget ConstructionType type);

    List<ConstructionTypeDto> toDtos(List<ConstructionType> types);

    Set<ConstructionTypeDto> toDtoSet(Set<ConstructionType> types);
}