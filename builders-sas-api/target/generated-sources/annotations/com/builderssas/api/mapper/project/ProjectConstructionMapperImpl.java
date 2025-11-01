package com.builderssas.api.mapper.project;

import com.builderssas.api.domain.model.project.ProjectConstruction;
import com.builderssas.api.domain.model.project.dto.CreateProjectConstructionDto;
import com.builderssas.api.domain.model.project.dto.ProjectConstructionDto;
import com.builderssas.api.domain.model.project.dto.UpdateProjectConstructionDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-01T09:43:56-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class ProjectConstructionMapperImpl implements ProjectConstructionMapper {

    @Override
    public ProjectConstructionDto toDto(ProjectConstruction projectConstruction) {
        if ( projectConstruction == null ) {
            return null;
        }

        ProjectConstructionDto projectConstructionDto = new ProjectConstructionDto();

        return projectConstructionDto;
    }

    @Override
    public ProjectConstruction toEntity(CreateProjectConstructionDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProjectConstruction projectConstruction = new ProjectConstruction();

        return projectConstruction;
    }

    @Override
    public void updateEntityFromDto(UpdateProjectConstructionDto dto, ProjectConstruction projectConstruction) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public List<ProjectConstructionDto> toDtos(List<ProjectConstruction> pcs) {
        if ( pcs == null ) {
            return null;
        }

        List<ProjectConstructionDto> list = new ArrayList<ProjectConstructionDto>( pcs.size() );
        for ( ProjectConstruction projectConstruction : pcs ) {
            list.add( toDto( projectConstruction ) );
        }

        return list;
    }

    @Override
    public Set<ProjectConstructionDto> toDtoSet(Set<ProjectConstruction> pcs) {
        if ( pcs == null ) {
            return null;
        }

        Set<ProjectConstructionDto> set = new LinkedHashSet<ProjectConstructionDto>( Math.max( (int) ( pcs.size() / .75f ) + 1, 16 ) );
        for ( ProjectConstruction projectConstruction : pcs ) {
            set.add( toDto( projectConstruction ) );
        }

        return set;
    }
}
