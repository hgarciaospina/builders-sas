package com.builderssas.api.domain.model.material.dto;

import lombok.*;

/**
 * DTO for creating a new MaterialsStock record.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMaterialsStockDto {

    /** ID of the associated MaterialType. */
    private Long materialTypeId;

    /** Initial quantity available. */
    private Long quantity;
}
