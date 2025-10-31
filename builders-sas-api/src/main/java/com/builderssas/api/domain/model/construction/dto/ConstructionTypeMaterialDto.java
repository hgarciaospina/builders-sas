package com.builderssas.api.domain.model.construction.dto;

import lombok.*;

/**
 * DTO for returning ConstructionTypeMaterial details.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionTypeMaterialDto {

    /** Primary key — unique identifier for the record. */
    private Long id;

    /** ID of the associated construction type. */
    private Long constructionTypeId;

    /** ID of the associated material type. */
    private Long materialTypeId;

    /** Quantity of material required for the construction type. */
    private Integer quantityRequired;
}
