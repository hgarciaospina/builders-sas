package com.builderssas.api.mapper.project;

import com.builderssas.api.domain.model.project.Project;
import com.builderssas.api.domain.model.project.dto.CreateProjectDto;
import com.builderssas.api.domain.model.project.dto.ProjectDto;
import com.builderssas.api.domain.model.project.dto.UpdateProjectDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-31T21:04:35-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDto toDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        return projectDto;
    }

    @Override
    public Project toEntity(CreateProjectDto dto) {
        if ( dto == null ) {
            return null;
        }

        Project project = new Project();

        return project;
    }

    @Override
    public void updateEntityFromDto(UpdateProjectDto dto, Project project) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<ProjectDto> toDtos(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectDto> list = new ArrayList<ProjectDto>( projects.size() );
        for ( Project project : projects ) {
            list.add( toDto( project ) );
        }

        return list;
    }

    @Override
    public Set<ProjectDto> toDtoSet(Set<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        Set<ProjectDto> set = new LinkedHashSet<ProjectDto>( Math.max( (int) ( projects.size() / .75f ) + 1, 16 ) );
        for ( Project project : projects ) {
            set.add( toDto( project ) );
        }

        return set;
    }
}
