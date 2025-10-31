package com.builderssas.api.mapper.material;

import com.builderssas.api.domain.model.material.MaterialsStock;
import com.builderssas.api.domain.model.material.dto.CreateMaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.MaterialsStockDto;
import com.builderssas.api.domain.model.material.dto.UpdateMaterialsStockDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MaterialsStockMapper {

    MaterialsStockDto toDto(MaterialsStock stock);

    MaterialsStock toEntity(CreateMaterialsStockDto dto);

    void updateEntityFromDto(UpdateMaterialsStockDto dto, @MappingTarget MaterialsStock stock);

    List<MaterialsStockDto> toDtos(List<MaterialsStock> stocks);

    Set<MaterialsStockDto> toDtoSet(Set<MaterialsStock> stocks);
}