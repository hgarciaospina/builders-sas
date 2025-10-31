package com.builderssas.api.domain.model.construction.dto;

import com.builderssas.api.domain.model.enums.OrderStatus;
import lombok.*;
import java.time.LocalDate;

/**
 * DTO for returning ConstructionOrder details.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionOrderDto {
    private Long id;
    private Long constructionRequestId;
    private Long projectConstructionId;
    private Long projectId;
    private Long constructionTypeId;
    private Long requestedByUserId;
    private Double latitude;
    private Double longitude;
    private LocalDate requestedDate;
    private LocalDate scheduledStartDate;
    private LocalDate scheduledEndDate;
    private OrderStatus orderStatus;
}