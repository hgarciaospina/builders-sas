package com.builderssas.api.domain.model.project.dto;

import com.builderssas.api.domain.model.enums.ProjectStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for returning Project details.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    /** Primary key — unique identifier for the project. */
    private Long id;

    /** Unique name of the project. */
    private String name;

    /** Optional detailed description of the project. */
    private String description;

    /** Project start date. */
    private LocalDate startDate;

    /** Current project status. */
    private ProjectStatus projectStatus;

    /** IDs of associated constructions (optional). */
    private Set<Long> constructionIds;

    /** IDs of associated orders (optional). */
    private Set<Long> orderIds;

    /** IDs of associated requests (optional). */
    private Set<Long> requestIds;
}
