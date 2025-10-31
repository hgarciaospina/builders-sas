package com.builderssas.api.mapper.project;

import com.builderssas.api.domain.model.project.*;
import com.builderssas.api.domain.model.construction.*;
import com.builderssas.api.domain.model.project.dto.CreateProjectDto;
import com.builderssas.api.domain.model.project.dto.ProjectDto;
import com.builderssas.api.domain.model.project.dto.UpdateProjectDto;
import org.mapstruct.*;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDto toDto(Project project);

    Project toEntity(CreateProjectDto dto);

    void updateEntityFromDto(UpdateProjectDto dto, @MappingTarget Project project);

    List<ProjectDto> toDtos(List<Project> projects);

    Set<ProjectDto> toDtoSet(Set<Project> projects);
}