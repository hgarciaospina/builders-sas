package com.builderssas.api.domain.model.construction.dto;

import lombok.*;
import java.util.Set;

/**
 * DTO for creating a new ConstructionType.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateConstructionTypeDto {

    /** Descriptive name of the construction type (e.g., "Residential House"). */
    private String name;

    /** Typical duration in days for this construction type. */
    private Integer durationDays;

    /** IDs of materials required for this construction type. */
    private Set<Long> materialIds;
}