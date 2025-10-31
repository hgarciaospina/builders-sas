package com.builderssas.api.mapper.construction;

import com.builderssas.api.domain.model.construction.ConstructionTypeMaterial;
import com.builderssas.api.domain.model.construction.dto.ConstructionTypeMaterialDto;
import com.builderssas.api.domain.model.construction.dto.CreateConstructionTypeMaterialDto;
import com.builderssas.api.domain.model.construction.dto.UpdateConstructionTypeMaterialDto;
import com.builderssas.api.mapper.construction.ConstructionTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {ConstructionTypeMapper.class})
public interface ConstructionTypeMaterialMapper {

    ConstructionTypeMaterialDto toDto(ConstructionTypeMaterial ctm);

    ConstructionTypeMaterial toEntity(CreateConstructionTypeMaterialDto dto);

    void updateEntityFromDto(UpdateConstructionTypeMaterialDto dto, @MappingTarget ConstructionTypeMaterial ctm);

    List<ConstructionTypeMaterialDto> toDtos(List<ConstructionTypeMaterial> ctms);

    Set<ConstructionTypeMaterialDto> toDtoSet(Set<ConstructionTypeMaterial> ctms);
}
