package com.builderssas.api.domain.model.construction.dto;

import lombok.*;
import java.time.OffsetDateTime;
import java.util.Set;

/**
 * DTO for returning ConstructionType details.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionTypeDto {

    /** Primary key — unique identifier for the construction type. */
    private Long id;

    /** Descriptive name of the construction type (e.g., "Residential House"). */
    private String name;

    /** Typical duration in days for this construction type. */
    private Integer durationDays;

    /** Timestamp when this construction type was created. */
    private OffsetDateTime createdAt;

    /** IDs of required materials (ConstructionTypeMaterial) */
    private Set<Long> materialIds;
}