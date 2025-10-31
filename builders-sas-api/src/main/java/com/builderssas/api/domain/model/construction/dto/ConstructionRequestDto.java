package com.builderssas.api.domain.model.construction.dto;

import com.builderssas.api.domain.model.enums.RequestStatus;
import lombok.*;
import java.time.LocalDate;

/**
 * DTO for returning ConstructionRequest details.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionRequestDto {
    private Long id;

    /** ProjectConstruction configuration ID this request belongs to */
    private Long projectConstructionId;

    /** Project ID this request belongs to */
    private Long projectId;

    /** ConstructionType ID being requested */
    private Long constructionTypeId;

    /** User ID who made the request */
    private Long requestedByUserId;

    /** Coordinate latitude for the construction */
    private Double latitude;

    /** Coordinate longitude for the construction */
    private Double longitude;

    /** Date when the request was made */
    private LocalDate requestedDate;

    /** Current status of the request (e.g., PENDING, APPROVED, REJECTED) */
    private RequestStatus requestStatus;
}