package com.builderssas.api.domain.model.construction.dto;

import com.builderssas.api.domain.model.enums.RequestStatus;
import lombok.*;

/**
 * DTO for updating an existing ConstructionRequest.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateConstructionRequestDto {

    /** Coordinate latitude for the construction */
    private Double latitude;

    /** Coordinate longitude for the construction */
    private Double longitude;

    /** Status of the request (e.g., PENDING, APPROVED, REJECTED) */
    private RequestStatus requestStatus;
}
