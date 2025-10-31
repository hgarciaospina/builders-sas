package com.builderssas.api.mapper.project;

import com.builderssas.api.domain.model.project.ProjectConstruction;
import com.builderssas.api.domain.model.project.dto.CreateProjectConstructionDto;
import com.builderssas.api.domain.model.project.dto.ProjectConstructionDto;
import com.builderssas.api.domain.model.project.dto.UpdateProjectConstructionDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProjectConstructionMapper {

    ProjectConstructionDto toDto(ProjectConstruction projectConstruction);

    ProjectConstruction toEntity(CreateProjectConstructionDto dto);

    void updateEntityFromDto(UpdateProjectConstructionDto dto, @MappingTarget ProjectConstruction projectConstruction);

    List<ProjectConstructionDto> toDtos(List<ProjectConstruction> pcs);

    Set<ProjectConstructionDto> toDtoSet(Set<ProjectConstruction> pcs);
}
