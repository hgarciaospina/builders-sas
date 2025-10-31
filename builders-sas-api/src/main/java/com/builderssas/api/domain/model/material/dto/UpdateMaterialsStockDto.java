package com.builderssas.api.domain.model.material.dto;

import lombok.*;

/**
 * DTO for updating an existing MaterialsStock record.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMaterialsStockDto {

    /** Updated ID of the associated MaterialType (optional). */
    private Long materialTypeId;

    /** Updated quantity available (optional). */
    private Long quantity;
}
