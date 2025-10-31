package com.builderssas.api.domain.model.user.dto;

import lombok.*;
import java.time.OffsetDateTime;

/**
 * DTO for returning UserRole details.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {

    /** Primary key — unique identifier for the user-role record. */
    private Long id;

    /** ID of the user associated with this role. */
    private Long userId;

    /** Username of the user (optional for convenience). */
    private String username;

    /** ID of the role assigned to the user. */
    private Long roleId;

    /** Role name (optional for convenience). */
    private String roleName;

    /** Timestamp when the role was assigned (optional). */
    private OffsetDateTime assignedAt;
}
