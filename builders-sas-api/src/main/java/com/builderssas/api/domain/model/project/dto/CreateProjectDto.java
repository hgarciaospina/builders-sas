package com.builderssas.api.domain.model.project.dto;

import com.builderssas.api.domain.model.enums.ProjectStatus;
import lombok.*;

import java.time.LocalDate;

/**
 * DTO for creating a new Project.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectDto {

    /** Unique name of the project. */
    private String name;

    /** Optional detailed description. */
    private String description;

    /** Project start date (optional). */
    private LocalDate startDate;

    /** Project status (optional, defaults to PLANNED). */
    private ProjectStatus projectStatus;
}
