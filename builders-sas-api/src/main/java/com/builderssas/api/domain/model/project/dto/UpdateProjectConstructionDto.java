package com.builderssas.api.domain.model.project.dto;

import com.builderssas.api.domain.model.enums.ConstructionStatus;
import lombok.*;

/**
 * DTO for updating an existing ProjectConstruction.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectConstructionDto {

    /** Updated project ID (optional). */
    private Long projectId;

    /** Updated ConstructionType ID (optional). */
    private Long constructionTypeId;

    /** Updated status of the construction type within the project (optional). */
    private ConstructionStatus constructionStatus;
}
