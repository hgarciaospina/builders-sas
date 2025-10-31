package com.builderssas.api.domain.model.user.dto;

import lombok.*;
import java.time.OffsetDateTime;

/**
 * DTO for updating an existing UserRole.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRoleDto {

    /** Optional updated user ID. */
    private Long userId;

    /** Optional updated role ID. */
    private Long roleId;

    /** Optional updated assignment timestamp. */
    private OffsetDateTime assignedAt;
}
