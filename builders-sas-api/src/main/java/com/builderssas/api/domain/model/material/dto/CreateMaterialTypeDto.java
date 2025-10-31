package com.builderssas.api.domain.model.material.dto;

import lombok.*;

/**
 * DTO for creating a new MaterialType.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMaterialTypeDto {

    /** Unique short code used to identify the material type. */
    private String code;

    /** Descriptive name of the material type. */
    private String name;
}
