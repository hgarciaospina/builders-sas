package com.builderssas.api.domain.model.construction.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * DTO for creating a new ConstructionOrder.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateConstructionOrderDto {
    private Long constructionRequestId;
    private Long projectConstructionId;
    private Long projectId;
    private Long constructionTypeId;
    private Long requestedByUserId;
    private Double latitude;
    private Double longitude;
    private LocalDate scheduledStartDate;
    private LocalDate scheduledEndDate;
}
