package com.builderssas.api.domain.model.material.dto;

import lombok.*;

/**
 * DTO for updating an existing MaterialType.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMaterialTypeDto {

    /** Updated short code (optional). */
    private String code;

    /** Updated descriptive name (optional). */
    private String name;
}
