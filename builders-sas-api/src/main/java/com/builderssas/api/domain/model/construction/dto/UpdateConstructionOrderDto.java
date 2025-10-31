package com.builderssas.api.domain.model.construction.dto;

import com.builderssas.api.domain.model.enums.OrderStatus;
import lombok.*;

import java.time.LocalDate;

/**
 * DTO for updating an existing ConstructionOrder.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateConstructionOrderDto {
    private Long projectConstructionId;
    private Double latitude;
    private Double longitude;
    private LocalDate scheduledStartDate;
    private LocalDate scheduledEndDate;
    private OrderStatus orderStatus;
}
