package com.builderssas.api.domain.model.material.dto;

import lombok.*;
import java.util.Set;

/**
 * DTO for returning MaterialType details.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialTypeDto {

    /** Primary key — unique identifier for the material type. */
    private Long id;

    /** Unique short code used to identify the material type. */
    private String code;

    /** Descriptive name of the material type. */
    private String name;

    /** IDs of associated stock records (optional). */
    private Set<Long> stockIds;
}
