package com.builderssas.api.domain.model.construction.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * DTO for creating a new ConstructionRequest.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateConstructionRequestDto {

    /** ProjectConstruction configuration ID this request belongs to */
    private Long projectConstructionId;

    /** Project ID this request belongs to */
    private Long projectId;

    /** ConstructionType ID being requested */
    private Long constructionTypeId;

    /** User ID who is making the request */
    private Long requestedByUserId;

    /** Coordinate latitude for the construction */
    private Double latitude;

    /** Coordinate longitude for the construction */
    private Double longitude;

    /** Date when the request is made */
    private LocalDate requestedDate;
}