package com.builderssas.api.domain.model.project.dto;

import com.builderssas.api.domain.model.enums.ConstructionStatus;
import lombok.*;

import java.util.Set;

/**
 * DTO for returning ProjectConstruction details.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectConstructionDto {

    /** Primary key — unique identifier for the ProjectConstruction. */
    private Long id;

    /** Project ID this configuration belongs to. */
    private Long projectId;

    /** ConstructionType ID associated with this project. */
    private Long constructionTypeId;

    /** Current status of the construction type within the project. */
    private ConstructionStatus constructionStatus;

    /** IDs of associated construction orders (optional). */
    private Set<Long> orderIds;
}
