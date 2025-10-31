package com.builderssas.api.domain.model.project.dto;

import com.builderssas.api.domain.model.enums.ConstructionStatus;
import lombok.*;

/**
 * DTO for creating a new ProjectConstruction.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectConstructionDto {

    /** Project ID this configuration belongs to. */
    private Long projectId;

    /** ConstructionType ID to associate with this project. */
    private Long constructionTypeId;

    /** Initial status of the construction type within the project (optional). */
    private ConstructionStatus constructionStatus;
}
