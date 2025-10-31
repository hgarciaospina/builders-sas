package com.builderssas.api.mapper.material;

import com.builderssas.api.domain.model.material.*;
import com.builderssas.api.domain.model.material.dto.CreateMaterialTypeDto;
import com.builderssas.api.domain.model.material.dto.MaterialTypeDto;
import com.builderssas.api.domain.model.material.dto.UpdateMaterialTypeDto;
import org.mapstruct.*;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MaterialTypeMapper {

    MaterialTypeDto toDto(MaterialType type);

    MaterialType toEntity(CreateMaterialTypeDto dto);

    void updateEntityFromDto(UpdateMaterialTypeDto dto, @MappingTarget MaterialType type);

    List<MaterialTypeDto> toDtos(List<MaterialType> types);

    Set<MaterialTypeDto> toDtoSet(Set<MaterialType> types);
}