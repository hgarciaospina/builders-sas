package com.builderssas.api.mapper.construction;

import com.builderssas.api.domain.model.construction.ConstructionRequest;
import com.builderssas.api.domain.model.construction.dto.ConstructionRequestDto;
import com.builderssas.api.domain.model.construction.dto.CreateConstructionRequestDto;
import com.builderssas.api.domain.model.construction.dto.UpdateConstructionRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ConstructionRequestMapper {

    ConstructionRequestDto toDto(ConstructionRequest request);

    ConstructionRequest toEntity(CreateConstructionRequestDto dto);

    void updateEntityFromDto(UpdateConstructionRequestDto dto, @MappingTarget ConstructionRequest request);

    List<ConstructionRequestDto> toDtos(List<ConstructionRequest> requests);

    Set<ConstructionRequestDto> toDtoSet(Set<ConstructionRequest> requests);
}
