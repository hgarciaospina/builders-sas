package com.builderssas.api.domain.model.enums;

/**
 * OrderStatus - lifecycle of a single construction order.
 */
public enum OrderStatus {
    REQUESTED,
    SCHEDULED,
    IN_PROGRESS,
    FINISHED,
    CANCELLED,
    PENDING
}
