package com.builderssas.api.domain.model.construction.dto;

import com.builderssas.api.domain.model.enums.RequestStatus;
import lombok.*;
import java.time.LocalDate;

/**
 * DTO for returning ConstructionRequest details.
 *
 * This class represents the data transfer object for construction requests.
 * It includes coordinates, request status, and related project/construction type IDs.
 * Lombok annotations generate getters, setters, constructors, and builder pattern.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionRequestDto {

    /** Unique identifier of the construction request */
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
