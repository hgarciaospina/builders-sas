package com.builderssas.api.domain.model.construction.dto;

import lombok.*;

/**
 * DTO for updating an existing ConstructionTypeMaterial.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateConstructionTypeMaterialDto {

    /** Updated ID of the associated construction type (optional). */
    private Long constructionTypeId;

    /** Updated ID of the associated material type (optional). */
    private Long materialTypeId;

    /** Updated quantity of material required (optional). */
    private Integer quantityRequired;
}
