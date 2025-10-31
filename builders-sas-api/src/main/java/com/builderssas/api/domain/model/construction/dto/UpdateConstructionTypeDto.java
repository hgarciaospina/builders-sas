package com.builderssas.api.domain.model.construction.dto;

import lombok.*;
import java.util.Set;

/**
 * DTO for updating an existing ConstructionType.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateConstructionTypeDto {

    /** Descriptive name of the construction type (optional). */
    private String name;

    /** Typical duration in days for this construction type (optional). */
    private Integer durationDays;

    /** Updated IDs of materials required for this construction type. */
    private Set<Long> materialIds;
}