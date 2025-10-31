package com.builderssas.api.domain.model.material.dto;

import lombok.*;

/**
 * DTO for returning MaterialsStock details.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialsStockDto {

    /** Primary key — unique identifier for the stock record. */
    private Long id;

    /** ID of the associated MaterialType. */
    private Long materialTypeId;

    /** Current quantity available for this material type. */
    private Long quantity;
}
