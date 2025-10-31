package com.builderssas.api.domain.model.enums;

/**
 * ProjectStatus - logical status used in services and mapped to DB string column project_status.
 */
public enum ProjectStatus {
    PLANNED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}
